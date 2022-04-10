package com.github.evgenius1424

import org.jfrog.gradle.plugin.artifactory.dsl.ArtifactoryPluginConvention

plugins {
    `maven-publish`
    id("com.jfrog.artifactory")
}

group = "com.github.evgenius1424"
version = "1.0"

configure<ArtifactoryPluginConvention>{
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


configure<PublishingExtension> {
    publications {
        register<MavenPublication>("mavenKotlin") {
            from(components.getByName("kotlin"))
        }
    }
}