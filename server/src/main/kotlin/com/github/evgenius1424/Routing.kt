package com.github.evgenius1424

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    routing {
        v1()
    }
}

private fun Routing.v1() {
    val company by inject<Company>()

    get("/api/v1/employees") {
        call.respond(company.getEmployees())
    }
}
