/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.tasks;

import javax.inject.Inject;
import org.gradle.api.DefaultTask;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

/**
 * Note : When I am using Property as input, I have not provided setters becoz
 * When the task is called from the script/or anywhere to set its inputs, gradle first calls the getter to get
 * property object and then gradle calls the set method on property object.
 *
 * Infact, if we provide setter method in it, it will result into exception.
 *
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyPrintingTask4 extends DefaultTask {

    @Input
    Property<String> inputName;

    @Input
    Property<String> inputMsg;

    @Inject
    public MyPrintingTask4(ObjectFactory objects) {

        this.inputName = objects.property(String.class);
        this.inputMsg = objects.property(String.class);
    }

    public Property<String> getInputName() {
        return inputName;
    }

    public Property<String> getInputMsg() {
        return inputMsg;
    }

    @TaskAction
    public void printing() {

        System.out.println("=========== Executing printing inside task4 ===========");
        System.out.println("Input name is ::: " + inputName.get() + " Input message is ::: " + inputMsg.get());
        System.out.println("=========== Completed executing printing inside task4 ============");
    }
}
