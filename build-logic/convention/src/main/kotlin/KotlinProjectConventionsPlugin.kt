import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinProjectConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.github.evgenius1424.kotlin-conventions")
                apply("com.github.evgenius1424.testing-conventions")
                apply("com.github.evgenius1424.integration-testing-conventions")
                apply("com.github.evgenius1424.ktlint-conventions")
                apply("com.github.evgenius1424.detekt-conventions")
                apply("com.github.evgenius1424.repositories-conventions")
                apply("com.github.evgenius1424.publishing-conventions")
                apply("com.github.evgenius1424.serialization-conventions")
                apply("com.github.evgenius1424.jacoco-conventions")
            }
        }
    }
}