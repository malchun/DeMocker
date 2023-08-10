rootProject.name = "pbfront"
pluginManagement{
    repositories{
        mavenCentral()
        maven("https://maven.vaadin.com/vaadin-prereleases")
        maven("https://maven.vaadin.com/vaadin-addons")
        maven("https://plugins.gradle.org/m2/")
    }
    plugins {
        id("com.vaadin") version ("24.0.5")
    }
}