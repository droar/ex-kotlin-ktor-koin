package com.droar.samples.ktor

import com.droar.samples.ktor.infrastructure.plugins.configureDatabases
import com.droar.samples.ktor.infrastructure.plugins.configureHTTP
import com.droar.samples.ktor.infrastructure.plugins.configureRouting
import com.droar.samples.ktor.infrastructure.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain.main

fun main(args: Array<String>) {
    main(args)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureHTTP()
    configureRouting()
}
