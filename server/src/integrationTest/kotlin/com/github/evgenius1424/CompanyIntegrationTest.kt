package com.github.evgenius1424

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension
import org.koin.core.KoinApplication
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.junit5.KoinTestExtension

internal class CompanyIntegrationTest : KoinTest {
    @RegisterExtension
    @JvmField
    val koinTestExtension = KoinTestExtension.create(KoinApplication::configureDI)

    @Test
    fun `DI smoke test`() {
        val company = get<Company>()
        assertThat(company).isInstanceOf(SmartCompany::class.java)
    }
}
