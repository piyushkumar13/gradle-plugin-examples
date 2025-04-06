/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions;

import com.piyush.example.pluginswithextensions.extensions.MyExtensionA;
import com.piyush.example.pluginswithextensions.tasks.MyPrintingTask3;
import com.piyush.example.pluginswithextensions.tasks.MyPrintingTask5;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyPlugin5WithExtension implements Plugin<Project> {


    @Override
    public void apply(@NotNull Project project) {

        MyExtensionA myExtensionA = project.getExtensions().getByType(MyExtensionA.class);

        project.getTasks().register("MyFivePrintingTask", MyPrintingTask5.class, myPrintingTask5 -> {

            myPrintingTask5.getInputName().set(myExtensionA.getName());
            myPrintingTask5.getInputMsg().set(myExtensionA.getMessage());

        });
    }
}
