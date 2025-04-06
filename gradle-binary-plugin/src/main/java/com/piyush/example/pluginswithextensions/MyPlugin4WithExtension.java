/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions;

import com.piyush.example.pluginswithextensions.extensions.MyExtensionA;
import com.piyush.example.pluginswithextensions.tasks.MyPrintingTask3;
import com.piyush.example.pluginswithextensions.tasks.MyPrintingTask4;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyPlugin4WithExtension implements Plugin<Project> {


    @Override
    public void apply(@NotNull Project project) {



        MyExtensionA myExtensionA = project.getExtensions().getByType(MyExtensionA.class);

        project.getTasks().register("MyFourthPrintingTask", MyPrintingTask4.class, myPrintingTask4 -> {

            myPrintingTask4.getInputName().set(myExtensionA.getName());
            myPrintingTask4.getInputMsg().set(myExtensionA.getMessage());

        });
    }
}
