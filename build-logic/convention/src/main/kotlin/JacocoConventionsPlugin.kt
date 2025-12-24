import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.named
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.tasks.JacocoReport

class JacocoConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("jacoco")
            }

            extensions.configure<JacocoPluginExtension> {
                toolVersion = "0.8.12"
            }

            tasks.named<JacocoReport>("jacocoTestReport") {
                dependsOn("test")

                reports {
                    xml.required.set(true)
                    csv.required.set(false)
                    html.outputLocation.set(layout.buildDirectory.dir("reports/jacoco/"))
                }
            }
        }
    }
}