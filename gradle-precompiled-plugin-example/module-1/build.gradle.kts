import com.piyush.plugins.HelloPlugin
import com.piyush.tasks.MyCustomTaskType

plugins {
    kotlin("jvm") version "2.1.10"
}

// Applying the custom precompiled plugin which registers hello-world task.
apply<HelloPlugin>()

tasks.register<MyCustomTaskType>("myTask")

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}