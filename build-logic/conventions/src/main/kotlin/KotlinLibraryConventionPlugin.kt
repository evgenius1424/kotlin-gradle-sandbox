import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("evgenius1424.kotlin.jvm")
                apply("evgenius1424.testing")
                apply("evgenius1424.testing.integration")
                apply("evgenius1424.code-quality")
                apply("evgenius1424.repositories")
                apply("evgenius1424.publishing")
                apply("evgenius1424.kotlin.serialization")
                apply("evgenius1424.coverage")
            }
        }
    }
}