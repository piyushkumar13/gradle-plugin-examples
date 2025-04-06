/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.tasks;

import javax.inject.Inject;
import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Property;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.Nested;
import org.gradle.api.tasks.TaskAction;

/**
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public abstract class MyPrintingTaskWithNesting6 extends DefaultTask {

    @Input
    Property<String> inputName;

    @Input
    Property<String> inputMsg;

    @Nested
    MyConfig additionalMyConfig;

    public static class MyConfig {

        @Input
        Property<String> inputDescription;


        public MyConfig(ObjectFactory objects) {
            this.inputDescription = objects.property(String.class);
        }

        public Property<String> getInputDescription() {
            return inputDescription;
        }
    }

    @Inject
    public MyPrintingTaskWithNesting6(ObjectFactory objects) {

        this.inputName = objects.property(String.class);
        this.inputMsg = objects.property(String.class);
        this.additionalMyConfig = new MyConfig(objects);
    }

    public Property<String> getInputName() {
        return inputName;
    }

    public Property<String> getInputMsg() {
        return inputMsg;
    }

    public MyConfig getAdditionalMyConfig() {
        return additionalMyConfig;
    }

    public void config(Action<? super MyConfig> action){

        action.execute(additionalMyConfig);
    }

    @TaskAction
    public void printing() {

        System.out.println("=========== Executing printing inside task6 ===========");
        System.out.println("Input name is ::: " + inputName.get() + " Input message is ::: " + inputMsg.get());
        System.out.println("Nested inputDescription ::: " + additionalMyConfig.getInputDescription().get());
        System.out.println("=========== Completed executing printing inside task6 ============");
    }
}
