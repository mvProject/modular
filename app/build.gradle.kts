plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = Config.compileSdk
    buildToolsVersion = Config.buildToolsVersion

    defaultConfig {
        applicationId = "com.mvproject.moduleskeleton"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.androidTestInstrumentation
    }

    signingConfigs {
        register("configRelease").configure {
            storeFile = file("../presale.jks")
            storePassword = "iq2umgo9"
            keyAlias = "presale"
            keyPassword = "iq2umgo9"
        }
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            setProperty(
                "archivesBaseName",
                "${rootProject.name}_${project.android.defaultConfig.versionName}"
            )
        }

        getByName("release") {
            signingConfig = signingConfigs.getByName("configRelease")
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            setProperty(
                "archivesBaseName",
                "${rootProject.name}_${project.android.defaultConfig.versionName}"
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
    implementation(project(":secondappmoodule"))
    implementation(project(":firstappmodule"))

    implementation(Dependencies.appLibraries)
    implementation(Dependencies.network)
    implementation(Dependencies.logging)
    implementation(Dependencies.lifecycleKtx)
    implementation(Dependencies.navigationKtx)

    hilt()

    testImplementation(Dependencies.testLibraries)
    androidTestImplementation(Dependencies.androidTestLibraries)
}
