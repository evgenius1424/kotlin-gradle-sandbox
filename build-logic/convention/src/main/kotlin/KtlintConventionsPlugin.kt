import org.gradle.api.Plugin
import org.gradle.api.Project

class KtlintConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jlleitschuh.gradle.ktlint")
            }
        }
    }
}