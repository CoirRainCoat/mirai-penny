plugins {
    java
    kotlin("jvm") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("net.mamoe:mirai-core-qqandroid:1.2.3")
    implementation( "org.jsoup", "jsoup", "1.13.1")
    implementation("com.google.zxing", "core", "3.4.0")
    implementation("mysql","mysql-connector-java","8.0.21")

    testCompile("junit", "junit", "4.12")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}