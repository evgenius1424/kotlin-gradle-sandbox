import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class SerializationConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.github.evgenius1424.kotlin-conventions")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            val libs = extensions.getByType(org.gradle.api.artifacts.VersionCatalogsExtension::class.java).named("libs")

            dependencies {
                "implementation"(libs.findLibrary("kotlinx-serialization-core").get())
            }
        }
    }
}