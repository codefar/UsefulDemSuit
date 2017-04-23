package com.davy.demo.processor;

import com.davy.demo.processor.model.DemoAnnotatedClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

/**
 * Created by davy on 2017/4/23.
 */

public abstract class AbstractBaseProcessor extends AbstractProcessor {

    protected Elements mElementUtils;
    protected Messager mMessager;
    protected Filer mFiler;
    protected Types mTypeUtils;

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        mElementUtils = env.getElementUtils();
        mFiler = env.getFiler();
        mTypeUtils = env.getTypeUtils();
        mMessager = env.getMessager();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    protected final void error(String msg, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.ERROR, String.format(msg, args));
    }

    protected final void info(String msg, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, String.format(msg, args));
    }
}
