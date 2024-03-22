plugins {
    id("aep-library")
}

val mavenCoreVersion: String by project

aepLibrary {
    namespace = "com.adobe.marketing.mobile.media"
    enableSpotless = true
    enableCheckStyle = true
    // A bug in the AEP Gradle plugin prevents proper javadoc generation for projects with internal subpackages. Dokka doc is used as a workaround.
    enableDokkaDoc = true
    publishing {
        gitRepoName = "aepsdk-media-android"
        addCoreDependency(mavenCoreVersion)
    }
}

dependencies {
    // Stop using SNAPSHOT after Core release.
    implementation("com.adobe.marketing.mobile:core:$mavenCoreVersion-SNAPSHOT")
}