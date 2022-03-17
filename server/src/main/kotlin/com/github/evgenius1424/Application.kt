package com.github.evgenius1424

import com.github.evgenius1424.di.applicationModule
import com.github.evgenius1424.plugins.configureRouting
import com.github.evgenius1424.plugins.configureSerialization
import io.ktor.application.Application
import io.ktor.server.netty.EngineMain
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.startKoin

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    startKoin {
        configureDI()
    }
    configureRouting()
    configureSerialization()
}

fun KoinApplication.configureDI() {
    modules(applicationModule)
}
