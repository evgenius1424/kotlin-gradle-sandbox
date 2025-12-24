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
        register("kotlinConventions") {
            id = "com.github.evgenius1424.kotlin-conventions"
            implementationClass = "KotlinConventionsPlugin"
        }
        register("kotlinProjectConventions") {
            id = "com.github.evgenius1424.kotlin-project-conventions"
            implementationClass = "KotlinProjectConventionsPlugin"
        }
        register("testingConventions") {
            id = "com.github.evgenius1424.testing-conventions"
            implementationClass = "TestingConventionsPlugin"
        }
        register("integrationTestingConventions") {
            id = "com.github.evgenius1424.integration-testing-conventions"
            implementationClass = "IntegrationTestingConventionsPlugin"
        }
        register("ktlintConventions") {
            id = "com.github.evgenius1424.ktlint-conventions"
            implementationClass = "KtlintConventionsPlugin"
        }
        register("detektConventions") {
            id = "com.github.evgenius1424.detekt-conventions"
            implementationClass = "DetektConventionsPlugin"
        }
        register("repositoriesConventions") {
            id = "com.github.evgenius1424.repositories-conventions"
            implementationClass = "RepositoriesConventionsPlugin"
        }
        register("publishingConventions") {
            id = "com.github.evgenius1424.publishing-conventions"
            implementationClass = "PublishingConventionsPlugin"
        }
        register("serializationConventions") {
            id = "com.github.evgenius1424.serialization-conventions"
            implementationClass = "SerializationConventionsPlugin"
        }
        register("jacocoConventions") {
            id = "com.github.evgenius1424.jacoco-conventions"
            implementationClass = "JacocoConventionsPlugin"
        }
        register("shadowConventions") {
            id = "com.github.evgenius1424.shadow-conventions"
            implementationClass = "ShadowConventionsPlugin"
        }
        register("applicationConventions") {
            id = "com.github.evgenius1424.application-conventions"
            implementationClass = "ApplicationConventionsPlugin"
        }
    }
}