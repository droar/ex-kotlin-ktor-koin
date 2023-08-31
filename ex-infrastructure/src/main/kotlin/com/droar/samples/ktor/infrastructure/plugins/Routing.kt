package com.droar.samples.ktor.infrastructure.plugins

import com.droar.samples.ktor.infrastructure.routing.bookRoutes
import com.droar.samples.ktor.infrastructure.routing.exampleRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        exampleRoutes()
        bookRoutes()
    }
}
