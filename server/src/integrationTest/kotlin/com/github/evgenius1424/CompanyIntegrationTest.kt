package com.github.evgenius1424

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.koin.test.KoinTest
import org.koin.test.get

internal class CompanyIntegrationTest : KoinTest {

    @Test
    fun `DI smoke test`() {
        initializeDI()
        val company = get<Company>()
        assertThat(company).isInstanceOf(SmartCompany::class.java)
    }
}
