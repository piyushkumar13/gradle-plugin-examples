/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

/**
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public abstract class MyPrintingTask5 extends DefaultTask {

    /*
    Gradle generates and inject the Property instances at runtime, when properties are abstract.
    This is the modern idiomatic way for custom task properties in Gradle.
    */
    @Input
    public abstract Property<String> getInputName();

    @Input
    public abstract Property<String> getInputMsg();

    @TaskAction
    public void printing() {

        System.out.println("=========== Executing printing inside task5 ===========");
        System.out.println("Input name is ::: " + getInputName().get() + " Input message is ::: " + getInputMsg().get());
        System.out.println("=========== Completed executing printing inside task5 ============");
    }
}
