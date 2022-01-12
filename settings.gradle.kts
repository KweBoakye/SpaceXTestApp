


pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.name == "kotlin-android-extensions") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }

            when (requested.id.id) {
                "com.squareup.sqldelight" -> {
                    useModule("com.squareup.sqldelight:gradle-plugin:${requested.version}")
                }
                "co.touchlab.native.cocoapods" -> {
                    useModule("co.touchlab:kotlinnativecocoapods:${requested.version}")
                }
                "dagger.hilt.android.plugin" -> {
                    useModule(
                        "com.google.dagger:hilt-android-gradle-plugin:${requested.version}")

                }
            }
        }
    }
}
rootProject.name = "SpaceXTestApp"

include(":androidApp")
include(":shared")
