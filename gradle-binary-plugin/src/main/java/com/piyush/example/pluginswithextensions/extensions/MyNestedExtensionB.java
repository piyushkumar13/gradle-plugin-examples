/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.extensions;

import org.gradle.api.Action;

/**
 *
 * For below nesting class, the build script configuration will look like as follows
 *
 * <pre>
 *
 *     MyExtensionForNestingA {
 *          inputName = "Nesting PK-A"
 *          inputMsg = "Hi from Nesting PK-A"
 *          additionalConfig {
 *             inputDescription = "Hi from Nesting PK-A description"
 *          }
 * }
 * </pre>
 * @author Piyush Kumar.
 * @since 06/04/25.
 */
public class MyNestedExtensionB {

    private String inputName;
    private String inputMsg;
    private NestedExtensionB1 additionalConfig;

    public MyNestedExtensionB() {

        this.inputName = null;
        this.inputMsg = null;
        this.additionalConfig = new NestedExtensionB1();

//        this.additionalConfig = objectFactory.newInstance(NestedExtensionB1.class); // we can also do this by injecting objectFactory in this constructor
    }

    public static final class NestedExtensionB1 {
        private String inputDescription;

        public String getInputDescription() {
            return inputDescription;
        }

        public void setInputDescription(String inputDescription) {
            this.inputDescription = inputDescription;
        }
    }

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

    public NestedExtensionB1 getAdditionalConfig() {
        return additionalConfig;
    }

    public void setAdditionalConfig(NestedExtensionB1 additionalConfig) {
        this.additionalConfig = additionalConfig;
    }

    /*Note : this method is important to provide nested closure in build script. */
    public void setAdditionalConfig(Action<? super NestedExtensionB1> action) {
        action.execute(additionalConfig);
    }

}
