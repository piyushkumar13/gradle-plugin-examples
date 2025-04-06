/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions;

import com.piyush.example.pluginswithextensions.tasks.MyPrintingTask1;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyPlugin1WithExtension implements Plugin<Project> {


    @Override
    public void apply(@NotNull Project project) {

        project.getTasks().register("MyFirstPrintingTask", MyPrintingTask1.class);
    }
}
