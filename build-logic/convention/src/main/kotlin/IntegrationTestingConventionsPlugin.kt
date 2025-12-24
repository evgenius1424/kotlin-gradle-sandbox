import org.gradle.api.Plugin
import org.gradle.api.Project

class IntegrationTestingConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.github.evgenius1424.kotlin-conventions")
                apply("jvm-test-suite")
            }
        }
    }
}