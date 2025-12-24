import org.gradle.api.Plugin
import org.gradle.api.Project

class RepositoriesConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            repositories.apply {
                gradlePluginPortal()
                mavenCentral()
            }
        }
    }
}