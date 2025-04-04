/**

Precompiled plugins are usually used when :
 * We want to share duplicate logic among multiple sub-projects (modules).
 * Build logic is getting complex in main build.gradle file. Using precompiled plugin, provides extra
clarity by dividing logic into classes, task etc.
 * You can unit test and debug the precompiled plugin.
Cons:
 * It cannot be shared with the other projects.

Precompiled plugins are of two types :
 * Precompiled script plugin also known as convention plugin - for sharing common dependencies between modules.
These dependencies will be available in classpath when plugin is applied.

 * Precompiled binary plugin - for creating common custom plugins, tasks which can be available in classpath.
These custom plugin, tasks will be available in jar in class path hence called as precompiled plugin

How to create Precompiled plugins ?
 * Precompiled plugins are created by creating a buildSrc directory at the main project root.
"buildSrc" directory is automatically recognized and compiled by gradle before any other component is compiled.

 * Apply the plugin groovy-gradle-plugin or java-gradle-plugin etc depending on the language,
which helps in creating precompiled plugin. This plugin is to be applied at the buildSrc build.gradle.

 * Now, you can add code at buildSrc/src/main/<groovy/kotlin/java> and tests at buildSrc/src/test/<groovy/kotlin/java>

 * Now, this precompiled can be used in the sub-projects(sub-modules) build.gradle or in main build.gradle by applying this plugin.
The id of this precompiled plugin will be same as the name of script file which you might have created under location
buildSrc/src/main/<groovy/kotlin/java> and it can be applied as plugin { id }

How compilation of Precompiled plugin happens(steps of compilation of precompiled plugin) ?
As a part of compilation of precompiled plugins - groovy-gradle-plugin or language specific plugin is used.
which will execute all the intermediatary steps to convert script to jar which will be end result.

Consider we have a build script with name precompiled-script-plugin.gradle at buildSrc/src/main/groovy/, following steps will take place
 * Step 1 : Every build script present within buildSrc directory, <language>-gradle-plugin will covert this script to a
class implementing DefaultScript interface. This class will be generated at buildSrc/build/groovy-dsl-plugin/

 * Step 2 : At this step, a plugin class will be generated for the script under buildSrc/build/classes.
Only job this plugin class will do to invoke script class generated in step 1 whenever this generated plugin is applied.

 * Step 3 : In order to apply the plugin by id, <language>-gradle-plugin will also create a property file under buildSrc/build/resources/main/META-INF/gradle-plugins/
The property file will have same file name as corresponding build script and inside it, it contains name of the class which implements plugin interface
i.e class generated in step 2. Ex - implementation-class=PrecompiledScriptPluginPlugin.

 * Step 4 : All the classes and resources generated above are packaged in jar file(buildSrc.jar) so that it is available at classpath
to be used by other subprojects or main project by just providing plugin id.

 * Step 5 : Apply the plugin as plugins { id("precompiled-script-plugin")}


Do not use cross project configuration
https://docs.gradle.org/current/userguide/sharing_build_logic_between_subprojects.html#sec:convention_plugins_vs_cross_configuration
 * In a typical Gradle setup, you write build scripts using either Groovy or Kotlin DSL (build.gradle or build.gradle.kts).
   These scripts are interpreted during the build process, making them flexible but potentially slower for larger projects.
   Pre-compiled Gradle scripts offer a way to improve build speed by converting reusable build logic into compiled plugins.

 * When build logic grows complex, or you need to share scripts across multiple projects, pre-compiling Gradle scripts ensures
   that they are transformed into binary plugins, allowing for quicker execution, improved type safety, and better code reuse.

Refer pages :
https://docs.gradle.org/current/userguide/custom_plugins.html#custom_plugins_2
https://docs.gradle.org/current/userguide/sharing_build_logic_between_subprojects.html (for buildSrc directory content)

Reference examples :
https://github.com/rivancic/gradle/tree/master/precompiled-script-plugin

 */


plugins {
    /* When we are creating kotlin based precompiled scripts like com.piyush.common-conventions-plugin.gradle.kts,
       we need to use kotlin-dsl plugin in build.gradle.kts of buildSrc file which provides way to create precompiled plugins,
       enhanced IDE experience like autocomplete etc.
       kotlin-dsl plugin is counter-part of groovy-gradle-plugin(for groovy based plugin).
       Details mentioned here :
       https://docs.gradle.org/current/userguide/sharing_build_logic_between_subprojects.html (search buildSrc/build.gradle.kts)
*/
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal() // Ensures kotlin("jvm") plugin can be resolved
}

dependencies {
    implementation(kotlin("gradle-plugin")) // Required for using kotlin("jvm")
}

