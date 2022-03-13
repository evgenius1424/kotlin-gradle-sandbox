package com.github.evgenius1424

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserTest {

    @Test
    fun `user should have a name`() {
        val user = User("Jack")
        assertThat(user.name).isEqualTo("Jack")
    }
}

