plugins {
    `kotlin-dsl`
}

object Plugins {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"
    const val ktlintPlugin = "org.jlleitschuh.gradle:ktlint-gradle:10.2.1"
    const val detektPlugin = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.19.0"
}

apply(from = "src/main/kotlin/com/github/evgenius1424/repositories-conventions.gradle.kts")

dependencies {
    implementation(Plugins.kotlinGradlePlugin)
    implementation(Plugins.ktlintPlugin)
    implementation(Plugins.detektPlugin)
}
