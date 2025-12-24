
plugins {
    id("evgenius1424.kotlin.application")
}

dependencies {
    implementation(project(":common"))

    implementation(libs.bundles.ktor.server)
    implementation(libs.koin.ktor)
    implementation(libs.logback.classic)

    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.koin.test.junit5)
}

application {
    mainClass.set("io.github.evgenius1424.kotlingradle.ApplicationKt")
}
