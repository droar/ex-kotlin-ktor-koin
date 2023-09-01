plugins {
    kotlin("jvm") version "1.9.10"
    id("io.kotest.multiplatform") version "5.0.2"
    id("io.ktor.plugin") version "2.3.3"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
}

group = "com.droar.samples.ktor.ex-ktor"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

tasks.test {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.droar.samples.ktor:ex-application")
    implementation("com.droar.samples.ktor:ex-infrastructure")
}
