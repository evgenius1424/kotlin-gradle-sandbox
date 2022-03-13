package com.github.evgenius1424

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class EmployeeIntegrationTest {

    @Test
    fun `user should have a name`() {
        val employee = Employee("Jack")
        assertThat(employee.name).isEqualTo("Jack")
    }
}
