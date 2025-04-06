/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author Piyush Kumar.
 * @since 04/04/25.
 */
public class MyCustomPlugin implements Plugin<Project> {


    @Override
    public void apply(@NotNull Project project) {

        project.getLogger().quiet("This is Piyush custom plugin");
        project.getLogger().quiet("========= Applying Piyush custom plugin =============");

        project.task("MyCustomTask1", task -> {
            task.doLast(customTask1 -> {
                System.out.println("MyCustomTask1 executed");
            });

        });

        project.getTasks().register("MyCustomTask2", task -> {
            task.doLast(customTask2 -> {
                System.out.println("MyCustomTask2 executed");
            });
        });
    }
}
