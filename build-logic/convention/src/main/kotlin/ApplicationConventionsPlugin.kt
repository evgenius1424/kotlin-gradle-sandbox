import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("application")
            }
        }
    }
}