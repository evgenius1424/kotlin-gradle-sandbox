plugins {
    `kotlin-dsl`
}

apply(from = "src/main/kotlin/com/github/evgenius1424/repositories-conventions.gradle.kts")

object Plugins {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21"
    const val ktlintPlugin = "org.jlleitschuh.gradle:ktlint-gradle:12.1.2"
    const val detektPlugin = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.23.7"
    const val kotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:2.0.21"
    const val shadowPlugin = "com.github.johnrengelman:shadow:8.1.1"
    const val artifactoryPlugin = "org.jfrog.buildinfo:build-info-extractor-gradle:latest.release"
}

dependencies {
    implementation(Plugins.kotlinGradlePlugin)
    implementation(Plugins.ktlintPlugin)
    implementation(Plugins.detektPlugin)
    implementation(Plugins.kotlinSerializationPlugin)
    implementation(Plugins.shadowPlugin)
    implementation(Plugins.artifactoryPlugin)
}
