package com.github.evgenius1424

import io.github.evgenius1424.kotlingradle.module
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompanyIntegrationTest {

    @Test
    fun `get company employees returns correct data`() =
        testApplication {
            application {
                module()
            }

            client.get("/api/v1/employees").apply {
                assertThat(status).isEqualTo(HttpStatusCode.OK)
                val responseText = bodyAsText()
                val json = Json.parseToJsonElement(responseText).jsonArray
                assertThat(json.size).isEqualTo(3) // Initial employees
            }
        }

    @Test
    fun `get company data returns correct structure`() =
        testApplication {
            application {
                module()
            }

            client.get("/api/v1/company").apply {
                assertThat(status).isEqualTo(HttpStatusCode.OK)
                val responseText = bodyAsText()
                val json = Json.parseToJsonElement(responseText).jsonObject
                val employees = json["employees"]?.jsonArray
                assertThat(employees?.size).isEqualTo(3)
            }
        }
}
