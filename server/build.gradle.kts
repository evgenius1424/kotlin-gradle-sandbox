
plugins {
    id("com.github.evgenius1424.kotlin-project-conventions")
    id("com.github.evgenius1424.application-conventions")
}

dependencies {
    implementation(project(":core-api"))
    implementation(project(":core-impl"))

    implementation(Dependencies.Ktor.ktorCore)
    implementation(Dependencies.Ktor.ktorServerNetty)
    implementation(Dependencies.Ktor.ktorSerialization)

    implementation(Dependencies.Koin.koinKtor)

    implementation(Dependencies.Logging.logback)

    integrationTestImplementation(Dependencies.Ktor.ktorServerTestHost)
    integrationTestImplementation(Dependencies.Koin.koinTest)
}

application {
    mainClass.set("com.github.evgenius1424.ApplicationKt")
}