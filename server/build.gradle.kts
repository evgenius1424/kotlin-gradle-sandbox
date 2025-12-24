
plugins {
    id("com.github.evgenius1424.kotlin-project-conventions")
    id("com.github.evgenius1424.application-conventions")
    id("com.github.evgenius1424.shadow-conventions")
}

dependencies {
    implementation(project(":core-api"))
    implementation(project(":core-impl"))

    implementation(libs.bundles.ktor.server)
    implementation(libs.koin.ktor)
    implementation(libs.logback.classic)

    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.koin.test.junit5)
}

application {
    mainClass.set("com.github.evgenius1424.ApplicationKt")
}
