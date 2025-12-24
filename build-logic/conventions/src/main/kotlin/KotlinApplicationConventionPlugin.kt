import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("evgenius1424.kotlin.library")
                apply("application")
                apply("com.github.johnrengelman.shadow")
            }
        }
    }
}