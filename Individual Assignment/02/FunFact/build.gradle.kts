// build.gradle.kts (Project-level)

plugins {
    // Update Kotlin version to 1.8.21
    kotlin("jvm") version "1.8.21" apply false
    id("com.android.application") version "8.1.0" apply false
    // You can add other plugins here if necessary
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
