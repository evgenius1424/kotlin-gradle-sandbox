
plugins {
    id("com.github.evgenius1424.kotlin-project-conventions")
    id("com.github.evgenius1424.application-conventions")
    id("com.github.evgenius1424.shadow-conventions")
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
