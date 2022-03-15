plugins {
    id("com.github.evgenius1424.kotlin-project-conventions")
}

dependencies {
    implementation(project(":core-api"))
    implementation(project(":core-impl"))

    implementation(Dependencies.Ktor.ktorCore)
    implementation(Dependencies.Ktor.ktorServerNettyJvm)
    implementation(Dependencies.Ktor.ktorServerContentNegotiation)
    implementation(Dependencies.Ktor.ktorSerializationKotlinxJson)

    implementation(Dependencies.Koin.koinCore)

    integrationTestImplementation(Dependencies.Koin.koinTest)
}
