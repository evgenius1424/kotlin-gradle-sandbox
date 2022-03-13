package com.github.evgenius1424

plugins {
    id("com.github.evgenius1424.kotlin-conventions")
    `jvm-test-suite`
}

/*
* Copied without changes from documentation
* https://docs.gradle.org/current/userguide/jvm_test_suite_plugin.html
*  */
testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }

        val integrationTest by registering(JvmTestSuite::class) {
            dependencies {
                implementation(project)
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
    }
}


tasks.named("check") {
    dependsOn(testing.suites.named("integrationTest"))
}

/*
* Documentation
* https://docs.gradle.org/current/userguide/java_testing.html#sec:configuring_java_integration_tests
*/
val integrationTestImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.testImplementation.get())
}


