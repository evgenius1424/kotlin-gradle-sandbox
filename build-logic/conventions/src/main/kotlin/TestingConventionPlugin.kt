import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.named

class TestingConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("evgenius1424.kotlin.jvm")
            }

            tasks.named<Test>("test") {
                useJUnitPlatform()
            }

            val libs = extensions.getByType(org.gradle.api.artifacts.VersionCatalogsExtension::class.java).named("libs")

            dependencies {
                "testImplementation"(libs.findLibrary("assertj-core").get())
                "testImplementation"(libs.findLibrary("junit-jupiter-api").get())
                "testRuntimeOnly"(libs.findLibrary("junit-jupiter-engine").get())
            }
        }
    }
}