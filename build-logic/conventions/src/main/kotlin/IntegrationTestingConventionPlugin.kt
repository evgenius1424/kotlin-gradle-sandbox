import org.gradle.api.Plugin
import org.gradle.api.Project

class IntegrationTestingConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("evgenius1424.kotlin.jvm")
                apply("jvm-test-suite")
            }
        }
    }
}