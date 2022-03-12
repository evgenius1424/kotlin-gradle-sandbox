plugins {
    `kotlin-dsl`
}

extra["gradleKtlintVersion"] = "10.2.1"

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:${property("gradleKtlintVersion")}")
}
