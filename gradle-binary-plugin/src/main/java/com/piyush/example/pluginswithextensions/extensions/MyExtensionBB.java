/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.extensions;

/**
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyExtensionBB {

    private String inputName;
    private String inputMsg;

    public MyExtensionBB() {

        this.inputName = "MyExtensionBB-defaultInputName";
        this.inputMsg = "MyExtensionBB-defaultInputMsg";
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
}
