import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.*

class IntegrationTestingConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("evgenius1424.kotlin.jvm")
            }

            val sourceSets = extensions.getByType<JavaPluginExtension>().sourceSets

            // Create integrationTest source set
            val integrationTestSourceSet = sourceSets.create("integrationTest") {
                compileClasspath += sourceSets["main"].output
                runtimeClasspath += sourceSets["main"].output
            }

            // Configure dependencies for integration test - extends from test configurations
            configurations {
                val integrationTestImplementation by getting {
                    extendsFrom(configurations["testImplementation"])
                }
                val integrationTestRuntimeOnly by getting {
                    extendsFrom(configurations["testRuntimeOnly"])
                }
            }

            // Create integration test task
            val integrationTest by tasks.registering(Test::class) {
                description = "Runs integration tests."
                group = "verification"

                testClassesDirs = integrationTestSourceSet.output.classesDirs
                classpath = integrationTestSourceSet.runtimeClasspath
                shouldRunAfter("test")

                useJUnitPlatform()
            }

            tasks.named("check") {
                dependsOn(integrationTest)
            }
        }
    }
}