package io.github.evgenius1424.kotlingradle

import io.github.evgenius1424.kotlingradle.repository.InMemoryIssuesRepository
import io.github.evgenius1424.kotlingradle.repository.IssuesRepository
import io.github.evgenius1424.kotlingradle.service.InMemoryIssuesService
import io.github.evgenius1424.kotlingradle.service.IssuesService
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
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import java.util.UUID

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    configureDI()
    configureSerialization()
    configureRouting()
}

fun Application.configureDI() {
    val issuesRepository = InMemoryIssuesRepository()
    val issuesService = InMemoryIssuesService(issuesRepository)

    install(DI)

    dependencies {
        provide<IssuesRepository> { issuesRepository }
        provide<IssuesService> { issuesService }
    }
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(
            Json {
                serializersModule =
                    SerializersModule {
                        contextual(UUIDSerializer)
                    }
            },
        )
    }
}

fun Application.configureRouting() {
    routing {
        get("/api/v1/issues") {
            val issuesService: IssuesService by dependencies
            call.respond(issuesService.getAllIssues())
        }

        get("/api/v1/issues/count") {
            val issuesService: IssuesService by dependencies
            call.respond(mapOf("count" to issuesService.getIssueCount()))
        }
    }
}

object UUIDSerializer : KSerializer<UUID> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

    override fun serialize(
        encoder: Encoder,
        value: UUID,
    ) = encoder.encodeString(value.toString())

    override fun deserialize(decoder: Decoder): UUID = UUID.fromString(decoder.decodeString())
}
