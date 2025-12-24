import org.gradle.api.Plugin
import org.gradle.api.Project

class DetektConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.gitlab.arturbosch.detekt")
            }
        }
    }
}