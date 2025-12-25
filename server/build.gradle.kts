
plugins {
    id("evgenius1424.kotlin.application")
}

dependencies {
    implementation(project(":common"))
    implementation(libs.kotlinx.datetime)

    implementation(libs.bundles.ktor.server)
    implementation(libs.logback.classic)

    testImplementation(libs.ktor.server.test.host)
}

application {
    mainClass.set("io.github.evgenius1424.kotlingradle.ApplicationKt")
}
