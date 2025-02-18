buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath(libs.com.android.tools.build.gradle)
    }
}

repositories {
    gradlePluginPortal()
    google()
}

plugins {
    id("io.gitlab.arturbosch.detekt") version libs.versions.detekt
}

detekt {
    toolVersion = libs.versions.detekt.get()
    input = files(subprojects.map {
        File(it.projectDir, "/src/main/kotlin")
    })
    buildUponDefaultConfig = true
    config = files("$projectDir/detekt-config.yml")
    baseline = file("$projectDir/detekt-baseline.xml")

    reports {
        html.enabled = true
        xml.enabled = true
    }
}

subprojects {
    repositories {
        mavenCentral()
        google()
    }

    group = Description.mavenGroup
}
