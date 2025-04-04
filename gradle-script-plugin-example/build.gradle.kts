/**
 Script plugins are of two type :
 Local - in which gradle script will be present locally.
 Remote - in which gradle script will be present remotely like in github

 Script plugins are usually used for modularizing your bit gradle file into multiple files.

 Pros of script plugin :
  * Decouples build logic as logic will be placed in separate build script so its reusable within the same project.
  * More manageable.
  * Simple

 Cons of script plugin :
  * Its not reusable across the projects.
  * Local script is not testable. We cannot write unit tests for testing it.
  * These cons even get more worse wtih remote plugins.
  *

 Applying plugin from separate file.
  * Groovy way - apply from : 'scriptPlugin.gradle'
  * Kotlin way - apply (from = 'scriptPlugin.gradle')

 If you want to run the script file directly which is other than build.gradle.kts or build.gradle.
 you can run it by either pointing rootProject.buildFileName = "specific script file name" or
 you can run gradlew(or gradle) cmd as ./gradlew --build-file <file name> or ./gradlew -b <file name>

 Convention of placing local script file is to keep it within gradle directly(which also contains wrapper) but its not mandatory.

 Refer pages :
 https://docs.gradle.org/current/userguide/custom_plugins.html#custom_plugins_2
 */

plugins {
    id("java")
//    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

logger.quiet("=========From the main file==========")

logger.quiet(":::: Calling local script plugin ::::")
apply(from = "gradle/localPlugin.gradle") // here, we can also call the http endpoint where script is present.
logger.quiet(":::: Local script plugin is being called ::::")

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}