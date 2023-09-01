package com.droar.samples.ktor

import com.droar.samples.ktor.application.services.BookService
import com.droar.samples.ktor.domain.usecases.BookUseCase
import com.droar.samples.ktor.infrastructure.plugins.configureDatabases
import com.droar.samples.ktor.infrastructure.plugins.configureHTTP
import com.droar.samples.ktor.infrastructure.plugins.configureRouting
import com.droar.samples.ktor.infrastructure.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.EngineMain.main
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

fun main(args: Array<String>) {

    val appModule = module {
        single<BookUseCase> { BookService() }
    }

    startKoin {
        modules(appModule)
    }

    main(args)
}

fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureHTTP()
    configureRouting()
}
