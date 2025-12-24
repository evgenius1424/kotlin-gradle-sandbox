import org.gradle.api.Plugin
import org.gradle.api.Project

class ShadowConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.github.johnrengelman.shadow")
            }
        }
    }
}