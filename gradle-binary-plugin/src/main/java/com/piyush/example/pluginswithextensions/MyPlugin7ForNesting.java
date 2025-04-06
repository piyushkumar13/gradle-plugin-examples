/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions;

import com.piyush.example.pluginswithextensions.extensions.MyNestedExtensionA;
import com.piyush.example.pluginswithextensions.extensions.MyNestedExtensionB;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Just checking the extensions in this plugin
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyPlugin7ForNesting implements Plugin<Project> {


    @Override
    public void apply(@NotNull Project project) {

        MyNestedExtensionA myNestedExtensionA = project.getExtensions().create("MyExtensionForNestingA", MyNestedExtensionA.class);
        MyNestedExtensionB myNestedExtensionB = project.getExtensions().create("MyExtensionForNestingB", MyNestedExtensionB.class);

        project.task("MyTaskForNestingA").doLast(task -> {

            System.out.println("myNestedExtensionA inputName ::: " + myNestedExtensionA.getInputName());
            System.out.println("myNestedExtensionA inputMsg ::: " + myNestedExtensionA.getInputMsg());
            System.out.println("myNestedExtensionA inputDescription ::: " + myNestedExtensionA.getAdditionalConfig().getInputDescription());

            System.out.println("myNestedExtensionB inputName ::: " + myNestedExtensionB.getInputName());
            System.out.println("myNestedExtensionB inputMsg ::: " + myNestedExtensionB.getInputMsg());
            System.out.println("myNestedExtensionB inputDescription ::: " + myNestedExtensionB.getAdditionalConfig().getInputDescription());
        });
    }
}
