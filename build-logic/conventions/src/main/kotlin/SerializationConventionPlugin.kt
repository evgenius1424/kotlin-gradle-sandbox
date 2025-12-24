import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class SerializationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("evgenius1424.kotlin.jvm")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            val libs = extensions.getByType(org.gradle.api.artifacts.VersionCatalogsExtension::class.java).named("libs")

            dependencies {
                "implementation"(libs.findLibrary("kotlinx-serialization-core").get())
            }
        }
    }
}