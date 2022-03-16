package com.github.evgenius1424

import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CompanyRoutesIntegrationTest {

    @Test
    fun `get company employees`() {
        withTestApplication(Application::module) {
            handleRequest(HttpMethod.Get, "/api/v1/employees").apply {
                assertThat(response.status()).isEqualTo(HttpStatusCode.OK)
            }
        }
    }
}
