object Dependencies {

    object Ktor {
        const val ktorCore = "io.ktor:ktor-server-core-jvm:2.0.0-beta-1"
        const val ktorServerNettyJvm = "io.ktor:ktor-server-netty-jvm:2.0.0-beta-1"
    }

    object Koin {
        const val version = "3.1.5"

        const val koinCore = "io.insert-koin:koin-core:$version"
        const val koinTest = "io.insert-koin:koin-test:$version"
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