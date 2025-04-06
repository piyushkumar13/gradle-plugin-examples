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
public class MyPrintingTask2 extends DefaultTask {

    @Input
    private String inputName;

    @Input
    private String inputMsg;

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputMsg() {
        return inputMsg;
    }

    public void setInputMsg(String inputMsg) {
        this.inputMsg = inputMsg;
    }

    @TaskAction
    public void printing() {

        System.out.println("=========== Executing printing inside task2 ===========");
        System.out.println("Input name is ::: " + inputName + " Input message is ::: " + inputMsg);
        System.out.println("=========== Completed executing printing inside task2 ============");
    }
}
