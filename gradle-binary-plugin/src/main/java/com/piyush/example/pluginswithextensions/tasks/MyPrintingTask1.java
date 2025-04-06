/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyPrintingTask1 extends DefaultTask {

    @TaskAction
    public void printing() {

        System.out.println("=========== Executing printing inside task1 ===========");
        System.out.println("=========== Completed executing printing inside task1 ============");

    }
}
