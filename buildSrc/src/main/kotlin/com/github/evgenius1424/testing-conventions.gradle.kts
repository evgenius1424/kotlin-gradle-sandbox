package com.github.evgenius1424

plugins {
    id("com.github.evgenius1424.kotlin-conventions")
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation(Dependencies.Utils.assertJCore)
    testImplementation(Dependencies.JUnit.api)
    testRuntimeOnly(Dependencies.JUnit.engine)
}