package com.davy.demo.processor;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;

/**
 * Created by davy on 2017/4/23.
 */

public class Logger {
    private Messager mMessager;

    public Logger(Messager mMessager) {
        this.mMessager = mMessager;
    }

    public void error(String msg, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args));
    }

    public void info(String msg, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, String.format(msg, args));
    }
}
