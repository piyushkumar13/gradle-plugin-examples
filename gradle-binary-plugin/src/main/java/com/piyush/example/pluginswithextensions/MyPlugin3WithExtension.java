/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions;

import com.piyush.example.pluginswithextensions.extensions.MyExtensionA;
import com.piyush.example.pluginswithextensions.tasks.MyPrintingTask3;
import com.piyush.example.pluginswithextensions.tasks.MyPrintingTask3A;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyPlugin3WithExtension implements Plugin<Project> {


    @Override
    public void apply(@NotNull Project project) {

        MyExtensionA myExtensionA = project.getExtensions().create("MyExtensionAForPrinting", MyExtensionA.class);

        project.getTasks().register("MyThirdPrintingTask", MyPrintingTask3.class, myPrintingTask3 -> {

            myPrintingTask3.getInputName().set(myExtensionA.getName());
            myPrintingTask3.getInputMsg().set(myExtensionA.getMessage());

        });

        project.getTasks().register("MyThirdAPrintingTask", MyPrintingTask3A.class, myPrintingTask3A -> {


            /* To set default value, we can also use convention method of extensions properties.
               Refer this :
               https://docs.gradle.org/current/userguide/implementing_gradle_plugins_precompiled.html#sec:plugin_conventions
               https://docs.gradle.org/current/userguide/implementing_gradle_plugins_binary.html#sec:plugin_conventions_in_binary_plugins */
            myPrintingTask3A.getInputName().set(myExtensionA.getName().orElse("Default Input name"));
            myPrintingTask3A.getInputMsg().set(myExtensionA.getMessage().orElse("Default Input msg"));

        });
    }
}
