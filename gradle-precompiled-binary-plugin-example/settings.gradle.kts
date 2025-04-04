plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "gradle-precompiled-binary-plugin-example"
//include("gradle-script-plugin-example")
//include("gradle-precompled-plugin-example")
//include("gradle-convention-precompiled-plugin")
//include("gradle-precompled-plugin-example:module-1")
//findProject(":gradle-precompled-plugin-example:module-1")?.name = "module-1"
//include("gradle-precompled-plugin-example:module-2")
//findProject(":gradle-precompled-plugin-example:module-2")?.name = "module-2"
//include("gradle-precompled-plugin-example:module-3")
//findProject(":gradle-precompled-plugin-example:module-3")?.name = "module-3"
include("module-1")
include("module-2")
