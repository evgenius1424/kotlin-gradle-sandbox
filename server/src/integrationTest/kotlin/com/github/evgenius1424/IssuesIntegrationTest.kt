package com.github.evgenius1424

import io.github.evgenius1424.kotlingradle.module
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class IssuesIntegrationTest {
    @Test
    fun `get issues returns correct data`() =
        testApplication {
            application {
                module()
            }

            client.get("/api/v1/issues").apply {
                assertThat(status).isEqualTo(HttpStatusCode.OK)
                val responseText = bodyAsText()
                val json = Json.parseToJsonElement(responseText).jsonArray
                assertThat(json.size).isEqualTo(3) // Initial issues
            }
        }

    @Test
    fun `get issues count returns correct structure`() =
        testApplication {
            application {
                module()
            }

            client.get("/api/v1/issues/count").apply {
                assertThat(status).isEqualTo(HttpStatusCode.OK)
                val responseText = bodyAsText()
                val json = Json.parseToJsonElement(responseText).jsonObject
                val count = json["count"]?.jsonPrimitive?.content?.toInt()
                assertThat(count).isEqualTo(3)
            }
        }
}
