/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */

package com.piyush.example.pluginswithextensions;

import com.piyush.example.pluginswithextensions.extensions.MyExtensionA;
import com.piyush.example.pluginswithextensions.extensions.MyExtensionAA;
import com.piyush.example.pluginswithextensions.extensions.MyExtensionB;
import com.piyush.example.pluginswithextensions.extensions.MyExtensionBA;
import com.piyush.example.pluginswithextensions.extensions.MyExtensionBB;
import com.piyush.example.pluginswithextensions.tasks.MyPrintingTask5;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Just checking the extensions in this plugin
 * @author Piyush Kumar.
 * @since 05/04/25.
 */
public class MyPlugin6WithExtension implements Plugin<Project> {


    @Override
    public void apply(@NotNull Project project) {

        /* We cannot use MyExtensionAA. Read MyExtensionAA java docs. */
//        MyExtensionAA myExtensionAA = project.getExtensions().create("MyExtensionAAForPrinting", MyExtensionAA.class);


        MyExtensionB myExtensionB = project.getExtensions().create("MyExtensionBForPrinting", MyExtensionB.class);
        MyExtensionBA myExtensionBA = project.getExtensions().create("MyExtensionBAForPrinting", MyExtensionBA.class);
        MyExtensionBB myExtensionBB = project.getExtensions().create("MyExtensionBBForPrinting", MyExtensionBB.class);

        project.task("PrintingExtensionsValues").doLast(task -> {
            System.out.println("myExtensionB name ::: " + myExtensionB.getInputName().getOrElse("OrElse inputName B"));
            System.out.println("myExtensionB message ::: " + myExtensionB.getInputMsg().getOrElse("OrElse inputMsg B"));

            System.out.println("myExtensionBA name ::: " + myExtensionBA.getInputName().getOrElse("OrElse inputName BA"));
            System.out.println("myExtensionBA message ::: " + myExtensionBA.getInputMsg().getOrElse("OrElse inputMsg BA"));

            System.out.println("myExtensionBB name ::: " + myExtensionBB.getInputName());
            System.out.println("myExtensionBB message ::: " + myExtensionBB.getInputMsg());

        });
    }
}
