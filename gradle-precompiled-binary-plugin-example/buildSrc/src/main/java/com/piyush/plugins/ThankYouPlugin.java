/*
 *  Copyright (c) 2024 Piyush Kumar
 *  All Rights Reserved Worldwide.
 */
package com.piyush.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

/**
 * @author Piyush Kumar.
 * @since 04/04/25.
 */
public class ThankYouPlugin implements Plugin<Project> {


    @Override
    public void apply(@NotNull Project project) {

        project.task("thank-you").doLast(task -> {

            project.getLogger().quiet("This is thankyou Task within ThankYouPlugin");
        });

    }
}
