val kotlinVersion = "1.7.10"

plugins {
    kotlin("multiplatform") version "1.7.10"
}

group = "a.khris"
version = "1.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

val kotlinWrappersVersion = "1.0.0-pre.365"

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
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
                implementation("org.kodein.di:kodein-di:7.12.0")
            }
        }

        val jsMain by getting {
            dependencies {

                implementation(project.dependencies.enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:$kotlinWrappersVersion"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom")

                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui-icons")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")


//                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
                //Kotlin React CSS (chapter 3)
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-css:17.0.2-pre.298-kotlin-1.6.10")

//                implementation(compose.web.core)
//                implementation(compose.runtime)
            }
        }
        val jsTest by getting {
            dependencies {
//                implementation(kotlin("test-js"))
            }
        }
//        val jvmMain by getting {
//            dependencies {
//            }
//        }
    }
}
