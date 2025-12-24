package io.github.evgenius1424.kotlingradle

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.netty.EngineMain
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module
import org.koin.ktor.ext.inject

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    startKoin {
        configureDI()
    }
    configureSerialization()
    configureRouting()
}

fun KoinApplication.configureDI() {
    modules(applicationModule)
}

val applicationModule =
    module {
        single<Company> { SmartCompany() }
    }

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}

fun Application.configureRouting() {
    routing {
        val company by inject<Company>()

        get("/api/v1/employees") {
            call.respond(company.getEmployees())
        }
    }
}
