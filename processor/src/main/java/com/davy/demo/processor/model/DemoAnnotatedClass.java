package com.davy.demo.processor.model;

/**
 * Created by davy on 2017/4/23.
 */

public class DemoAnnotatedClass {
    private String showName;
    private String className;

    public DemoAnnotatedClass() {
    }

    public DemoAnnotatedClass(String showName, String className) {
        this.showName = showName;
        this.className = className;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "DemoAnnotatedClass{" +
                "showName='" + showName + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
