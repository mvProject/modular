plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = Config.compileSdk
    buildToolsVersion = Config.buildToolsVersion

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
        testInstrumentationRunner = Config.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        android.buildFeatures.viewBinding = true
    }
}

dependencies {
    implementation(project(":base"))

    implementation(Dependencies.appLibraries)
    implementation(Dependencies.network)
    implementation(Dependencies.logging)
    implementation(Dependencies.navigationKtx)

    hilt()

    testImplementation(Dependencies.testLibraries)
    androidTestImplementation(Dependencies.androidTestLibraries)
}
