plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.kotlin.serialization.gradlePlugin)
    implementation(libs.ktlint.gradlePlugin)
    implementation(libs.detekt.gradlePlugin)
    implementation(libs.shadow.gradlePlugin)
    implementation(libs.artifactory.gradlePlugin)
}

kotlin {
    jvmToolchain(21)
}

gradlePlugin {
    plugins {
        register("kotlinJvm") {
            id = "evgenius1424.kotlin.jvm"
            implementationClass = "KotlinJvmConventionPlugin"
        }
        register("kotlinLibrary") {
            id = "evgenius1424.kotlin.library"
            implementationClass = "KotlinLibraryConventionPlugin"
        }
        register("kotlinApplication") {
            id = "evgenius1424.kotlin.application"
            implementationClass = "KotlinApplicationConventionPlugin"
        }
        register("testing") {
            id = "evgenius1424.testing"
            implementationClass = "TestingConventionPlugin"
        }
        register("integrationTesting") {
            id = "evgenius1424.testing.integration"
            implementationClass = "IntegrationTestingConventionPlugin"
        }
        register("codeQuality") {
            id = "evgenius1424.code-quality"
            implementationClass = "CodeQualityConventionPlugin"
        }
        register("repositories") {
            id = "evgenius1424.repositories"
            implementationClass = "RepositoriesConventionPlugin"
        }
        register("publishing") {
            id = "evgenius1424.publishing"
            implementationClass = "PublishingConventionPlugin"
        }
        register("serialization") {
            id = "evgenius1424.kotlin.serialization"
            implementationClass = "SerializationConventionPlugin"
        }
        register("coverage") {
            id = "evgenius1424.coverage"
            implementationClass = "CoverageConventionPlugin"
        }
    }
}