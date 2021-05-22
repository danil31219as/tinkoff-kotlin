package com.example.group

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


fun Application.groupModule() {
    val service: GroupService by closestDI().instance()

    routing {
        route("/groups") {
            get {
                call.respond(service.findAll())
            }
            get("{id}"){
                val id = (call.parameters["id"] ?: "0").toInt()
                call.respond(service.findOne(id))
            }
            post {
                val request = call.receive<CreateGroupRequest>()
                call.respond(service.create(request.titleFac, request.number))
            }
            put("{id}") {
                val id = (call.parameters["id"] ?: "0").toInt()
                val request = call.receive<CreateGroupRequest>()
                call.respond(service.update(id, request.titleFac, request.number))
            }
            delete("id") {
                val id = (call.parameters["id"] ?: "0").toInt()
                call.respond(service.delete(id))
            }
        }
    }
}

fun DI.Builder.groupComponents() {
    bind<GroupDao>() with singleton { GroupDao(instance()) }
    bind<GroupService>() with singleton { GroupService(instance(), instance()) }
}

@Serializable
private data class CreateGroupRequest(val titleFac: String, val number: Int)