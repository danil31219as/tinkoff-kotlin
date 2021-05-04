val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
    kotlin("jvm") version "1.5.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.0"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation ("io.ktor:ktor-serialization:$ktor_version")
    implementation ("io.ktor:ktor-server-netty:$ktor_version")
    implementation ("ch.qos.logback:logback-classic:$logback_version")

    implementation ("io.github.config4k:config4k:0.4.2")
    implementation("com.google.code.gson:gson:2.8.5")
    implementation ("org.flywaydb:flyway-core:7.7.3")
    implementation ("com.h2database:h2:1.4.200")
    implementation ("org.jetbrains.exposed:exposed-jdbc:0.30.1")

    implementation ("org.kodein.di:kodein-di-framework-ktor-server-jvm:7.5.0")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
}