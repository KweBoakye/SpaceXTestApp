val sqlDelightVersion: String by project

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("co.touchlab.native.cocoapods")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
}
group = "com.kweboakye.spacextestapp"
version = "1.0-SNAPSHOT"

sqldelight {
    database("SpaceXTestAppDatabase") {
        packageName = "com.kweboakye.spacextestapp.shared.data"
        schemaOutputDirectory = file("src/main/sqldelight")
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 31
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    configurations {
        create("androidTestApi")
        create("androidTestDebugApi")
        create("androidTestReleaseApi")
        create("testApi")
        create("testDebugApi")
        create("testReleaseApi")
    }
}


kotlin {
    android()

    val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
    if (onPhone) {
        iosArm64("ios")
    } else {
        iosX64("ios")
    }

    cocoapodsext {
        homepage = "https://github.com/KweBoakye"
        summary = "summary"
        framework {
            isStatic = false
        }
    }
    sourceSets {
        val kotlinVersion = "1.4.10"
        val ktorVersion = "1.4.0"
        val commonMain by getting {
            dependencies {
                api(
                    "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2-native-mt")
                api(
                    "org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC")
                api("io.ktor:ktor-client-core:$ktorVersion")
                api("io.ktor:ktor-client-serialization:$ktorVersion")
                api("com.squareup.sqldelight:runtime:$sqlDelightVersion")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                api("io.ktor:ktor-client-android:$ktorVersion")
                api("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.1")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
                implementation(
                    "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2-native-mt") {
                    version {
                        strictly("1.4.2-native-mt")
                    }
                }
            }
        }
        val iosTest by getting
    }
}

kotlin.targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
    binaries.all {
        freeCompilerArgs += "-Xdisable-phases=EscapeAnalysis"
    }
}

/*
val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)*/
