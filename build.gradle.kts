plugins {
    kotlin("multiplatform") version "1.6.10"
    // KSP support
    id("com.google.devtools.ksp") version "1.6.10-1.0.2"
}

group = "a.khris"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

val fritz2Version = "1.0-RC1"

kotlin {
//    jvm()
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
        dependencies {
            implementation("dev.fritz2:core:$fritz2Version")
//            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
        }
    }

        val jsMain by getting {
            dependencies {
//                implementation(compose.web.core)
//                implementation(compose.runtime)
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
//        val jvmMain by getting {
//            dependencies {
//            }
//        }
    }
}

/**
 * KSP support - start
 */
dependencies {
    add("kspMetadata", "dev.fritz2:lenses-annotation-processor:$fritz2Version")
}
kotlin.sourceSets.commonMain { kotlin.srcDir("build/generated/ksp/commonMain/kotlin") }
tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().all {
    if (name != "kspKotlinMetadata") dependsOn("kspKotlinMetadata")
}
// needed to work on Apple Silicon. Should be fixed by 1.6.20 (https://youtrack.jetbrains.com/issue/KT-49109#focus=Comments-27-5259190.0-0)
rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().nodeVersion = "16.0.0"
}
/**
 * KSP support - end
 */
