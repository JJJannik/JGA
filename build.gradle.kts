plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "de.jjjannik"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io/")
}

dependencies {
    implementation("org.slf4j", "slf4j-log4j12", "2.0.1")
    implementation("org.apache.logging.log4j", "log4j-api", "2.19.0")
    implementation("org.apache.logging.log4j", "log4j-core", "2.19.0")
    implementation("com.squareup.okhttp3", "okhttp", "4.10.0")
    implementation("com.google.code.gson", "gson", "2.10.1")

    compileOnly("org.projectlombok", "lombok", "1.18.32")
    annotationProcessor("org.projectlombok", "lombok", "1.18.32")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    shadowJar {
        archiveFileName.set("JGA-$version.jar")
    }
    javadoc {
        source = sourceSets.main.get().allJava
        setDestinationDir(reporting.file("./build/libs/javadoc"))
    }
}