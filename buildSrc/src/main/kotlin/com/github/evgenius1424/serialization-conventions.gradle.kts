package com.github.evgenius1424

plugins {
    id("com.github.evgenius1424.kotlin-conventions")
    kotlin("plugin.serialization")
}


dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2")
}