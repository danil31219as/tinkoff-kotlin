
import com.example.AppConfig
import com.example.group.Group
import com.example.student.StudentDao
import com.example.student.StudentService
import com.example.student.StudentWithGroup
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Database
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.ktor.closestDI
import org.kodein.di.ktor.di
import org.kodein.di.singleton
import java.net.URI
import com.google.gson.*
import com.typesafe.config.ConfigFactory
import io.github.config4k.extract
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse


fun Application.studentModule() {
    val service: StudentService by closestDI().instance()

    routing {
        route("/students") {
            get {
                call.respond(service.findAll())
            }
            get("{id}"){
                val config = ConfigFactory.load().extract<AppConfig>()
                val id = (call.parameters["id"] ?: "0").toInt()
                val student = service.findOne(id)
                val gson = Gson()
                val client = HttpClient.newBuilder().build();
                val request = HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:${config.http.port}/groups/${student.groupId}"))
                    .build();

                val result =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
                val group: Group =
                    gson.fromJson(result.body(), Group::class.java)

                call.respond(StudentWithGroup(id, student.name, group.number, group.titleFac))
            }
            post {
                val request = call.receive<CreateStudentRequest>()
                call.respond(service.create(request.name, request.groupId))
            }
            put("{id}") {
                val id = (call.parameters["id"] ?: "0").toInt()
                val request = call.receive<CreateStudentRequest>()
                call.respond(service.update(id, request.name, request.groupId))
            }
            delete("id") {
                val id = (call.parameters["id"] ?: "0").toInt()
                call.respond(service.delete(id))
            }

        }
    }
}

fun DI.Builder.studentComponents() {
    bind<StudentDao>() with singleton { StudentDao(instance()) }
    bind<StudentService>() with singleton { StudentService(instance(), instance()) }
}

@Serializable
private data class CreateStudentRequest(val name: String, val groupId: Int)