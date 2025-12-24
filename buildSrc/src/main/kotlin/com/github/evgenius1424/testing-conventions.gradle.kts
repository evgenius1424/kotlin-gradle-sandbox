package com.github.evgenius1424

plugins {
    id("com.github.evgenius1424.kotlin-conventions")
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation("org.assertj:assertj-core:3.26.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.3")
}