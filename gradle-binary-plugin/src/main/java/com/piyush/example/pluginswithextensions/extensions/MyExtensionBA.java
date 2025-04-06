/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.extensions;

import javax.inject.Inject;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Property;

/**
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyExtensionBA {

    private Property<String> inputName;
    private Property<String> inputMsg;

    @Inject // You can avoid this annotation as well. Gradle will inject ObjectFactory.
    public MyExtensionBA(ObjectFactory objectFactory) {

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
