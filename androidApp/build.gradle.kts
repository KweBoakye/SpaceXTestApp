plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}
group = "com.kweboakye.spacextestapp"
version = "1.0-SNAPSHOT"

val hiltVersion: String by project

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.1.0-rc01")
    // Tooling support (Previews, etc.)
    implementation ("androidx.compose.ui:ui-tooling:1.0.5")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.1.0-rc01")
    // Material Design
    implementation("androidx.compose.material:material:1.1.0-rc01")
    implementation("com.google.android.material:material:1.4.0")

    implementation("androidx.compose.runtime:runtime:1.1.0-rc01")
    implementation("androidx.compose.runtime:runtime-livedata:1.1.0-rc01")
    implementation("androidx.fragment:fragment-ktx:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("androidx.activity:activity:1.4.0")
    implementation("androidx.activity:activity-ktx:1.4.0")
    implementation("androidx.activity:activity-compose:1.4.0")

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    //kapt("androidx.hilt:hilt-compiler:1.0.0-alpha02")
    kapt("com.google.dagger:hilt-android-compiler:2.40.5")
    //implementation("com.google.dagger:dagger:2.30")
    //kapt("com.google.dagger:dagger-compiler:2.30")
}
android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.kweboakye.spacextestapp.androidApp"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
   /* buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }*/

    buildToolsVersion = "30.0.3"

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
        //useIR = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-rc02"
    }
}
