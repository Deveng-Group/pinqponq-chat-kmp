import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.vanniktech.mavenPublish)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

group = "io.pinqponq"
version = generateVersionName()

kotlin {
    jvm("desktop")

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        outputModuleName = "pinqponqchat"
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "pinqponqchat.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    androidTarget {
        publishLibraryVariants("release")
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "pinqponqchat"
            isStatic = true
        }
    }


    explicitApi()


    sourceSets {
        val desktopMain by getting

        androidMain.dependencies {

        }

        commonMain.dependencies {
            implementation(compose.material3)

        }

        desktopMain.dependencies {

        }

        nativeMain.dependencies {

        }
    }
}

android {
    namespace = "io.pinqponq.chat"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    buildFeatures {
        compose = true
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(
        group.toString(),
        "chat-kmp",
        version.toString()
    )

    pom {
        name = "pinqponq Chat KMP"
        description = "pinqponq chat library for Deveng projects"
        inceptionYear = "2024"
        url = "https://github.com/furkanturkn/pinqponq-chat-kmp/"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "furkanturkn"
                name = "Furkan Türkan"
                url = "https://github.com/furkanturkn/"
            }
        }
        scm {
            url = "https://github.com/furkanturkn/pinqponq-chat-kmp/"
            connection = "scm:git:git://github.com/furkanturkn/pinqponq-chat-kmp.git"
            developerConnection =
                "scm:git:ssh://git@github.com/furkanturkn/pinqponq-chat-kmp.git"
        }
    }
}


fun generateVersionName(): String {
    val versionMajor = libs.versions.app.version.major.get()
    val appVersionCode = libs.versions.app.version.code.get()

    val minorVersion = libs.versions.app.minor.version.get()

    return StringBuilder().apply {
        append(versionMajor)
        append(".")
        append(appVersionCode)
        append(".")
        append(minorVersion)
    }.toString()
}
