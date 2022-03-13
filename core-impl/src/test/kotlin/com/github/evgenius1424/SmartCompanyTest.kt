package com.github.evgenius1424

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SmartCompanyTest {

    @Test
    fun `add employee to company`() {
        val employee = Employee("Jack")

        val company = SmartCompany()

        company.addEmployee(employee)

        assertThat(company.getEmployees()).containsExactly(employee)
    }
}
