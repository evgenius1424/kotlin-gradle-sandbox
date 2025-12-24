package io.github.evgenius1424.kotlingradle

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.netty.EngineMain
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.di.DI
import io.ktor.server.plugins.di.dependencies
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    configureDI()
    configureSerialization()
    configureRouting()
}

fun Application.configureDI() {
    val company = SmartCompany()
    val employeeService = EmployeeServiceImpl(company)

    install(DI)

    dependencies {
        provide<Company> { company }
        provide<EmployeeService> { employeeService }
    }
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}

fun Application.configureRouting() {
    routing {
        get("/api/v1/employees") {
            val employeeService: EmployeeService by dependencies
            call.respond(employeeService.getAllEmployees())
        }

        get("/api/v1/company") {
            val company: Company by dependencies
            call.respond(mapOf("employees" to company.getEmployees()))
        }
    }
}
