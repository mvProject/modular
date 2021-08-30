plugins {
    id("org.jlleitschuh.gradle.ktlint").version(Versions.ktLint)
}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLint}")
    }
}

ktlint {
    version.set("0.36.0")
    android.set(true)
    filter {
        exclude("**/build/**")
        exclude("**/resources/**")
        exclude("**/generated/**")
    }
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.HTML)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<org.jlleitschuh.gradle.ktlint.KtlintFormatTask> {
    setSource(files(rootDir))
}

tasks.withType<org.jlleitschuh.gradle.ktlint.BaseKtlintCheckTask> {
    setSource(files(rootDir))
}
