/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.extensions;

import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Property;

/**
 * This extension is using class. If we want to have more control and don't want gradle to instantiate
 * the properties, then we can use classes.
 *
 * Usually, idiomatic way to create extensions is using interfaces or abstract classes having properties getter abstract methods
 * where gradle can instantiate it at runtime.
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyExtensionB {

    private Property<String> inputName;
    private Property<String> inputMsg;

    public MyExtensionB(ObjectFactory objectFactory) {

        this.inputName = objectFactory.property(String.class);
        this.inputMsg = objectFactory.property(String.class);
    }

    public Property<String> getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName.set(inputName);
    }

    public Property<String> getInputMsg() {
        return inputMsg;
    }

    public void setInputMsg(String inputMsg) {
        this.inputMsg.set(inputMsg);
    }
}
