object Dependencies {

    object Ktor {
        const val version = "1.6.8"

        const val ktorCore = "io.ktor:ktor-server-core:$version"
        const val ktorServerNetty = "io.ktor:ktor-server-netty:$version"
        const val ktorSerialization = "io.ktor:ktor-serialization:$version"
        const val ktorServerTestHost = "io.ktor:ktor-server-test-host:$version"
    }

    object Koin {
        const val version = "3.1.5"

        const val koinKtor = "io.insert-koin:koin-ktor:$version"
        const val koinTest = "io.insert-koin:koin-test-junit5:$version"
    }

    object Logging {
        const val logback = "ch.qos.logback:logback-classic:1.3.0-alpha14"
    }

    object JUnit {
        const val version = "5.8.1"
        const val api = "org.junit.jupiter:junit-jupiter-api:$version"
        const val engine = "org.junit.jupiter:junit-jupiter-engine:$version"
    }

    object Utils {
        const val assertJCore = "org.assertj:assertj-core:3.22.0"
    }
}