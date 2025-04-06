/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.extensions;

/**
 *
 * For below nesting class, the build script configuration will look like as follows
 *
 * <pre>
 *
 *     MyExtensionForNestingA {
 *          inputName = "Nesting PK-A"
 *          inputMsg = "Hi from Nesting PK-A"
 *          additionalConfig.inputDescription = "Hi from Nesting PK-A description"
 * }
 * </pre>
 *
 * Notice, additional config is provided with . object notation.
 * How can I provided nested object also as additionalConfig {} instead of using . object notation. For this check MyNestedExtensionB
 * @author Piyush Kumar.
 * @since 06/04/25.
 */
public class MyNestedExtensionA {

    private String inputName;
    private String inputMsg;
    private NestedExtensionA1 additionalConfig;

    public MyNestedExtensionA() {

        this.inputName = null;
        this.inputMsg = null;
        this.additionalConfig = new NestedExtensionA1();
    }

    public static final class NestedExtensionA1 {
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

    public NestedExtensionA1 getAdditionalConfig() {
        return additionalConfig;
    }

    public void setAdditionalConfig(NestedExtensionA1 additionalConfig) {
        this.additionalConfig = additionalConfig;
    }
}
