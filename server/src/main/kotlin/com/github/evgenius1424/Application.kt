package com.github.evgenius1424

import com.github.evgenius1424.di.applicationModule
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.koin.core.context.GlobalContext.startKoin

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
    }.start(wait = true)
    initializeDI()
}

fun initializeDI() {
    startKoin {
        modules(applicationModule)
    }
}
