val ktorVersion: String by project
val logbackVersion: String by project

plugins {
    val kotlinVersion = "1.8.21"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
    application
}

group = "me.vladkanash"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //base
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")

    //json handling
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    //logging
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}