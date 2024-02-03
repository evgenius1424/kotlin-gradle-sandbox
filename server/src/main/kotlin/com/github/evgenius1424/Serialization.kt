package com.github.evgenius1424

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.serialization.json

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}
