buildscript {

    repositories {
        google()
        mavenCentral()
        maven("https://jcenter.bintray.com/")
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath(Classpath.gradle)
        classpath(Classpath.gradlePlugin)
        classpath(Classpath.googleServices)
        classpath(Classpath.firebaseCrashlytics)
        classpath(Classpath.hilt)
        classpath(Classpath.navigationGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.20")
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://jcenter.bintray.com/")

    }
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
