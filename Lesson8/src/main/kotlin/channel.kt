import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Student>()
    launch {
        // this might be heavy CPU-consuming computation or async logic, we'll just send five squares
        for (id in 1..5) channel.send(Student(id, "User $id"))
    }
    // here we print five received integers:
    repeat(5) { println("There is a new user ${channel.receive().name}") }
}