/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.extensions;

import org.gradle.api.provider.Property;

/**
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public interface MyExtensionA {

    /*
    Gradle generates and inject the Property instances at runtime, when properties are abstract.
    This is the modern idiomatic way for custom task properties in Gradle.
    */
    Property<String> getName();
    Property<String> getMessage();
}
