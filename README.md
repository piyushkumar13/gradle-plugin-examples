# About Project

This project contains multiple modules as follows : 

1. **gradle-script-plugin-example** - This contains examples of local script plugin.
2. **gradle-precompiled-convention-plugin-example** - This contains examples of `precompiled-convention-plugin` which is being 
used when we want to have common configuration at one place which can be reused within multiple modules.
3. **gradle-precompiled-binary-plugin-example** - This contains examples of `precompiled-binary-plugin`. It contains custom plugins and custom task types.
4. **gradle-binary-plugin** - This contains examples of binary plugin, which gets published to local maven. 
However, you can also publish on remote private repository. This plugin contains custom plugins, custom task types, custom extensions examples.
The `binary-plugin` is similar to `precompiled-binary-plugin`, only difference is that `binary-plugin` can be used
across projects, whereas `precompiled-binary-plugin` cannot be used across projects but can be used only across modules.


**NOTE:** Each module is a standalone project so don't consider them as module.
However, each of these standalone project(module) may have modules within them, those are actual nested modules.
Check each standalone projects `settings.gradle.kts`.

**NOTE:** I have also added proper comments in build.gradle.kts files and wherever required. Follow comments to understand concepts.