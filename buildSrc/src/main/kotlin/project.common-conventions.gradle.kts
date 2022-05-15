plugins {
    `java-library`
}

repositories {
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.cosmogrp.net/repository/libs-public/") {
        name = "CosmoLibs"
        credentials(PasswordCredentials::class)
    }
    mavenCentral()
}

tasks {
    java {
        toolchain {
            languageVersion.set(
                JavaLanguageVersion.of(
                    "${findProperty("java")}"
                )
            )
        }
    }

    compileJava {
        options.compilerArgs.add("-parameters")
    }
}