import org.gradle.kotlin.dsl.kotlin

plugins {
    /* to have kotlin jvm here, which is obviously going to be used by modules when com.piyush.common-conventions-plugin.gradle.kts plugin is applied.
    We need to add following in buldSrc build.gradle.kts
    repositories {
      gradlePluginPortal() // Ensures Kotlin plugins can be resolved
    }

    and
    dependencies {
      implementation(kotlin("gradle-plugin")) // Required for using kotlin("jvm")
      // or implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
    }
    */
    kotlin("jvm")
}


logger.quiet("=========== My Common Conventions Plugin =========")
tasks.register("My Convention Precompiled Plugin Task") {

    doLast {
        println("Executed My Convention Precompiled Plugin Task")
    }
}

tasks.test {
    useJUnitPlatform()
}

repositories {
    mavenCentral()
}

dependencies{
//    implementation("com.google.guava:guava:33.4.6-jre")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

kotlin {
    jvmToolchain(17)
}