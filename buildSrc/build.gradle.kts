plugins {
    `kotlin-dsl`
}

apply(from = "src/main/kotlin/com/github/evgenius1424/repositories-conventions.gradle.kts")

object Plugins {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"
    const val ktlintPlugin = "org.jlleitschuh.gradle:ktlint-gradle:10.2.1"
    const val detektPlugin = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0"
    const val kotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:1.6.0"
    const val shadowPlugin = "gradle.plugin.com.github.jengelman.gradle.plugins:shadow:7.0.0"
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
