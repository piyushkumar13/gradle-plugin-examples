plugins {
    id("java")

    /* About java-gradle-plugin refer below links:
       https://docs.gradle.org/current/userguide/java_gradle_plugin.html#java_gradle_plugin
       https://docs.gradle.org/current/userguide/custom_plugins.html#sec:custom_plugins_standalone_project
       It will add the META-INF and plugin properties file under it for the plugin details specified in gradlePlugin{..} below
       and also, java-gradle-plugin provides plugin apis to help in development of plugins and
       some other features as mentioned in above link. */
    id("java-gradle-plugin")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

// this block with the help of "java-gradle-plugin"(Gradle Plugin Development Plugin),
// creates the META-INF with plugin details in properties file under META-INF.
gradlePlugin {
    plugins {
        create("ThankYouPlugin") {
            id = "my-thank-you-plugin" // usually, name of the plugin is given in the pattern like com.something.<plugin name> etc.
            implementationClass = "com.piyush.plugins.ThankYouPlugin"
        }
    }
}