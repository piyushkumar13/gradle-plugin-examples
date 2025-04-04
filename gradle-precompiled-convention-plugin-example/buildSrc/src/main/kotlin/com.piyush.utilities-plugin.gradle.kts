import org.gradle.kotlin.dsl.kotlin

plugins {
    id("com.piyush.my-common-conventions-plugin")
}


logger.quiet("=========== My Utilities Plugin =========")
tasks.register("My Utilities Plugin Task") {

    doLast {
        println("Executed My Utilities Plugin Task")
    }
}
dependencies{
    implementation("com.google.guava:guava:33.4.6-jre")
}