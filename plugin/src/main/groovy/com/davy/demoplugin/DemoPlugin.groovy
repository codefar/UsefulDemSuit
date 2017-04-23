package com.davy.demoplugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class DemoPlugin implements Plugin<Project> {

    public static final String EXTENSION_NAME = "printMessage";//扩展别名

    @Override
    public void apply(Project target) {
        DemoExtension extension=  target.extensions.create(EXTENSION_NAME, DemoExtension);
        target.task("printMessage") << {
                println extension.message
        }
    }
}