import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register

class PublishingConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("maven-publish")
                apply("com.jfrog.artifactory")
            }

            group = "com.github.evgenius1424"
            version = "1.0"

            configure<PublishingExtension> {
                publications {
                    register<MavenPublication>("mavenKotlin") {
                        from(components.getByName("kotlin"))
                    }
                }
            }

            // Note: Artifactory configuration moved to a separate config block
            // since it requires runtime configuration
            afterEvaluate {
                extensions.configure<org.jfrog.gradle.plugin.artifactory.dsl.ArtifactoryPluginConvention> {
                    setContextUrl("http://127.0.0.1:8081/artifactory")
                    publish {
                        repository {
                            setRepoKey("libs-snapshot-local")
                            setUsername("user")
                            setPassword("password")
                        }

                        defaults {
                            publications("mavenKotlin")
                            setPublishArtifacts(true)
                            setPublishPom(true)
                            setPublishIvy(false)
                        }
                    }
                }
            }
        }
    }
}