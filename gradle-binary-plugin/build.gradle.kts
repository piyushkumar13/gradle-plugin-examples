import com.piyush.example.pluginswithextensions.tasks.MyPrintingTask2
import com.piyush.example.pluginswithextensions.tasks.MyPrintingTask3
import com.piyush.example.pluginswithextensions.tasks.MyPrintingTaskWithNesting6

/**
Binary plugin is completely same as precompiled-binary-plugin, only difference is that binary plugin is published to the
artifact repository so that it can be shared with other projects as well.

Binary plugins can be published to following artifacts repository :
 * Local Maven Repository
 * Private Maven Repository
 * Gradle Plugin Portal

Usually, recommendation is to have a separate repostory to have its code. However, currently I have added it as a module in
gradle-plugin-example but its actually a standalone module.


* */
plugins {

   /* About java-gradle-plugin refer below links:
   https://docs.gradle.org/current/userguide/java_gradle_plugin.html#java_gradle_plugin
   https://docs.gradle.org/current/userguide/custom_plugins.html#sec:custom_plugins_standalone_project
   It will add the META-INF and plugin properties file under it for the plugin details specified in gradlePlugin{..} below
   and also, java-gradle-plugin provides plugin apis to help in development of plugins and
   some other features as mentioned in above link. */
    id("java-gradle-plugin") // this plugin can also be used when we are writing plugins in kotlin or groovy coz this plugin provides api for plugins development.

    /*This is used to publish the artifacts/jars to a repository.
      Here, we will use it to publish plugin. */
    id("maven-publish")

    /* Here, we are using, our own plugin created in this gradle-binary-plugin module itself.
       To use it in this way, we need to publish the jar for this project to maven local and then use it by also mentioning,
       PluginManagement.repository in settings.gradle.kts. Check settings.gradle.kts. */
    id("my-custom-plugin") version "1.0-SNAPSHOT"
    id("my-plugin-1-with-extension") version "1.0-SNAPSHOT"
    id("my-plugin-2-with-extension") version "1.0-SNAPSHOT"
    id("my-plugin-3-with-extension") version "1.0-SNAPSHOT"
    id("my-plugin-4-with-extension") version "1.0-SNAPSHOT"
    id("my-plugin-5-with-extension") version "1.0-SNAPSHOT"
    id("my-plugin-6-with-extension") version "1.0-SNAPSHOT"
    id("my-plugin-7-for-nesting") version "1.0-SNAPSHOT"
}

group = "com.piyush.plugins"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// this block with the help of "java-gradle-plugin"(Gradle Plugin Development Plugin),
// creates the META-INF with plugin details in properties file under META-INF.
gradlePlugin {
    plugins {
        create("MyCustomPlugin") {
            id = "my-custom-plugin" // usually, name of the plugin is given in the pattern like com.something.<plugin name> etc.
            implementationClass = "com.piyush.example.plugins.MyCustomPlugin"
        }

        create("MyPlugin1WithExtension") {
            id = "my-plugin-1-with-extension"
            implementationClass = "com.piyush.example.pluginswithextensions.MyPlugin1WithExtension"
        }

        create("MyPlugin2WithExtension") {
            id = "my-plugin-2-with-extension"
            implementationClass = "com.piyush.example.pluginswithextensions.MyPlugin2WithExtension"
        }

        create("MyPlugin3WithExtension") {
            id = "my-plugin-3-with-extension"
            implementationClass = "com.piyush.example.pluginswithextensions.MyPlugin3WithExtension"
        }

        create("MyPlugin4WithExtension") {
            id = "my-plugin-4-with-extension"
            implementationClass = "com.piyush.example.pluginswithextensions.MyPlugin4WithExtension"
        }

        create("MyPlugin5WithExtension") {
            id = "my-plugin-5-with-extension"
            implementationClass = "com.piyush.example.pluginswithextensions.MyPlugin5WithExtension"
        }

        create("MyPlugin6WithExtension") {
            id = "my-plugin-6-with-extension"
            implementationClass = "com.piyush.example.pluginswithextensions.MyPlugin6WithExtension"
        }

        create("MyPlugin7ForNesting") {
            id = "my-plugin-7-for-nesting"
            implementationClass = "com.piyush.example.pluginswithextensions.MyPlugin7ForNesting"
        }
    }
}

MyExtensionAForPrinting{
    name = "PK"
    message = "Hi from PK"

}

MyExtensionBForPrinting{
    inputName = "PK-B"
    inputMsg = "Hi from PK-B"

}

MyExtensionBAForPrinting{
    inputName = "PK-BA"
    inputMsg = "Hi from PK-BA"

}

MyExtensionBBForPrinting{
    inputName = "PK-BB"
    inputMsg = "Hi from PK-BB"

}


MyExtensionForNestingA{
    inputName = "Nesting PK-A"
    inputMsg = "Hi from Nesting PK-A"
    additionalConfig.inputDescription = "Hi from Nesting PK-A description"
}

MyExtensionForNestingB{
    inputName = "NestingB PK-A"
    inputMsg = "Hi from NestingB PK-A"
    setAdditionalConfig { // it will use the name of the setter having action.
        // If setter name had been additionalConfig, then we can use additionalConfig{...}

        inputDescription = "Hi from NestingB PK-A description"
    }
}


// I can also use the taskType in script
tasks.register<MyPrintingTask2>("ScriptMyPrintingTask2"){
    inputName = "Script-task2-PK"
    inputMsg = "Script-task2-Hi from PK"
}

tasks.register<MyPrintingTask3>("ScriptMyPrintingTask3"){
    inputName = "Script-task3-PK"
    inputMsg = "Script-task3-Hi from PK"
}

tasks.register<MyPrintingTaskWithNesting6>("ScriptMyPrintingTask6"){
    inputName = "Script-task6-Nested-PK"
    inputMsg = "Script-task6-Hi from Nested PK"


//    additionalMyConfig.inputDescription = "Script-task6-Hi from Nesting PK description"

    config {
        inputDescription = "Script-task6-Hi from Nested PK description"
    }


}

//dependencies {
//    testImplementation(platform("org.junit:junit-bom:5.10.0"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
//}

//tasks.test {
//    useJUnitPlatform()
//}