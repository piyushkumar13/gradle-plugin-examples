/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions.extensions;

import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.Property;

/**
 * If you use below interface, you will get error :
 * <br>
 * <code>
 *   Could not create an instance of type com.piyush.example.pluginswithextensions.extensions.MyExtensionAA
 *   Could not generate a decorated class for type MyExtensionAA.
 *   Cannot have abstract method MyExtensionAA.getMessage()
 * </code>
 *
 * This error is because Gradle can only generate extension objects from interfaces that follow certain rules.
 *
 * Gradle cannot decorate plain interfaces with just abstract methods. It needs the methods to return Gradle-managed types,
 * like Property<T>, so it can manage their lifecycle, lazy evaluation, and serialization.
 *
 * If you use this ways :
 *
 * <pre>
 * public interface MyExtensionAA {
 *     Property<String> getName();
 *     Property<String> getMessage();
 * }
 * </pre>
 * Now Gradle can create a dynamic implementation of this interface and inject Property<String> instances into it automatically.
 *
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public interface MyExtensionAA { // Not correct way, read above java docs.

    String getName();
    String getMessage();
}
