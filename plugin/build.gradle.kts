import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    id("project.common-conventions")
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

tasks {
    shadowJar {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")
    }

    named<DefaultTask>("build") {
        dependsOn("shadowJar")
    }
}

dependencies {
    compileOnly(libs.spigot)
}

bukkit {
    val projectName = "${findProperty("plugin-name")}"

    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
    main = "net.cosmogrp.${projectName.toLowerCase()}.${projectName}Plugin"
    apiVersion = "1.13"
    version = "${project.version}"
    authors = listOf("CosmoGroup Development")
    description = "${findProperty("plugin-description")}"
    name = projectName
}
