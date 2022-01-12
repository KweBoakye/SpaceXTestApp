
plugins {
    val kotlinVersion = "1.6.10"
    val androidBuildToolsPluginVersion = "7.0.0"
    id("com.android.application") version androidBuildToolsPluginVersion apply false
    id("com.android.library") version androidBuildToolsPluginVersion apply false
    kotlin("android") version kotlinVersion apply false
    kotlin("multiplatform") version kotlinVersion apply false
    kotlin("kapt") version kotlinVersion apply false
    id("dagger.hilt.android.plugin") version "2.30.1-alpha" apply false
    id("com.squareup.sqldelight") version "1.4.3" apply false
    id("co.touchlab.native.cocoapods") version "0.11" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version kotlinVersion apply false
    id("io.gitlab.arturbosch.detekt") version "1.15.0-RC1"
    id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
}

allprojects {
    group = "com.kweboakye.spacextestapp"
    version = "1.0-SNAPSHOT"
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}

subprojects {

    apply {
        plugin("io.gitlab.arturbosch.detekt")
        plugin("org.jlleitschuh.gradle.ktlint")
    }

    ktlint {
        debug.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }


    detekt {
        config = rootProject.files("config/detekt/detekt.yml")
        reports {
            html.enabled = true
            xml.enabled = true

        }
    }
}

repositories {
    google()
    jcenter()
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}
