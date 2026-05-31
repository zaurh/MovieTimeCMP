import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    jvm()
    
    js {
        browser()
    }
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }
    
    androidLibrary {
       namespace = "com.zaurh.movietimenew.shared"
       compileSdk = libs.versions.android.compileSdk.get().toInt()
       minSdk = libs.versions.android.minSdk.get().toInt()
    
       compilerOptions {
           jvmTarget = JvmTarget.JVM_11
       }
       androidResources {
           enable = true
       }
       withHostTest {
           isIncludeAndroidResources = true
       }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)

            implementation("io.insert-koin:koin-android:4.2.1")
            implementation("io.insert-koin:koin-androidx-compose:4.2.1")

            implementation("io.ktor:ktor-client-okhttp:3.5.0")
            implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.4")
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation("io.insert-koin:koin-core:4.2.1")
            implementation("io.insert-koin:koin-compose:4.2.1")
            implementation("io.insert-koin:koin-compose-viewmodel:4.2.1")

            implementation("io.ktor:ktor-client-core:3.5.0")
            implementation("io.ktor:ktor-client-content-negotiation:3.5.0")
            implementation("io.ktor:ktor-serialization-kotlinx-json:3.5.0")

            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.9.2")

            implementation("io.coil-kt.coil3:coil-compose:3.0.4")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation("io.ktor:ktor-client-java:3.5.0")
            implementation("io.coil-kt.coil3:coil-network-ktor3:3.0.4")
        }
        jsMain.dependencies {
            implementation("io.coil-kt.coil3:coil-network-ktor3:3.0.4")
            implementation(libs.wrappers.browser)
        }

        iosMain.dependencies {
            implementation("io.ktor:ktor-client-darwin:3.5.0")
            implementation("io.coil-kt.coil3:coil-network-ktor3:3.0.4")
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}