package com.droar.samples.ktor.infrastructure.routing

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.exampleRoutes() {
    // Example routes
    route("") {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/json/kotlinx-serialization") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}

