/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * @author Piyush Kumar.
 * @since 04/04/25.
 */
public class MyCustomTaskType extends DefaultTask {

    @TaskAction
    public void sayHello() {

        System.out.println("Saying hello from MyCustomTask");
    }
}
