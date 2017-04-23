package com.davy.demo.processor;

import com.davy.demo.annotation.Demo;
import com.davy.demo.annotation.DemoClassName;
import com.davy.demo.processor.model.DemoAnnotatedClass;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
public class DemoFragmentProcessor extends AbstractProcessor {

    private Elements mElementUtils;
    private Logger mLogger;
    private Filer mFiler;
    private Types mTypeUtils;

    private Map<String, DemoAnnotatedClass> annotatedClasses = new HashMap<>();

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        mElementUtils = env.getElementUtils();
        mFiler = env.getFiler();
        mTypeUtils = env.getTypeUtils();
        mLogger = new Logger(env.getMessager());
    }

    @Override
    public boolean process(Set<? extends TypeElement> annoations, RoundEnvironment roundEnv) {
        mLogger.info("DemoFragmentProcessor process " + Arrays.toString(annoations.toArray()));

        processDemo(roundEnv);

        if (roundEnv.processingOver()) {
            try {
                generate(annotatedClasses.values());
            } catch (IOException e) {
                mLogger.error("Couldn't generate class " + e.toString());
            }
        }

        return true;
    }

    private void processDemo(RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Demo.class)) {
            TypeElement typeElement = (TypeElement) element;
            mLogger.info("processDemo className " + getPackageName(typeElement));
            if (!isValidClass(typeElement)) {
                return;
            }

            try {
                buildAnnotatedClass(typeElement);
            } catch (IOException e) {
                String message = String.format("Couldn't process class %s: %s", typeElement,
                        e.getMessage());
                mLogger.error(message, element);
                e.printStackTrace();
            }
        }
        mLogger.info(Arrays.toString(annotatedClasses.values().toArray()));
    }

    private void buildAnnotatedClass(TypeElement typeElement) throws IOException {
        DemoAnnotatedClass demoAnnotatedClass = new DemoAnnotatedClass();
        demoAnnotatedClass.setClassName(typeElement.getQualifiedName().toString());
        Demo demo = typeElement.getAnnotation(Demo.class);
        String name = demo.name();
        if (name == null || name.length() <= 0) {
            name = typeElement.getClass().getSimpleName();
        }
        demoAnnotatedClass.setShowName(name);
        annotatedClasses.put(demoAnnotatedClass.getShowName(), demoAnnotatedClass);
    }

    private void generate(Collection<DemoAnnotatedClass> annotatedClasses) throws IOException {

        final String pkgName = DemoClassName.DEMO_PKG_NAME;
        final String className = DemoClassName.DEMO_CLASS_NAME;

        ArrayList<DemoAnnotatedClass> classes = new ArrayList<>(annotatedClasses);

        ClassName hashMap = ClassName.get(Map.class);
        TypeName mapTypeName = ParameterizedTypeName.get(hashMap, ClassName.get(String.class), ClassName.get(String.class));

        CodeBlock.Builder builder = CodeBlock.builder();
        builder.addStatement("demos = new $T()", HashMap.class);
        for (DemoAnnotatedClass demoAnnotatedClass : classes) {
            builder.addStatement("demos.put(\"$N\" , \"$N\")", demoAnnotatedClass.getShowName(), demoAnnotatedClass.getClassName());

        }
        CodeBlock initCodeBlock = builder.build();

        FieldSpec demosField = FieldSpec.builder(mapTypeName, "demos")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .build();

        TypeSpec demoEntryList = TypeSpec.classBuilder(className)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addField(demosField)
                .addStaticBlock(initCodeBlock)
                .build();

        JavaFile javaFile = JavaFile.builder(pkgName, demoEntryList)
                .build();
        javaFile.writeTo(mFiler);
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(Demo.class.getCanonicalName());
        return Collections.unmodifiableSet(types);
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    private boolean isValidClass(TypeElement typeElement) {
        return typeElement.getKind() == ElementKind.CLASS;
    }

    public String getPackageName(TypeElement type) {
        return mElementUtils.getPackageOf(type).getQualifiedName().toString();
    }

    private static String getClassName(TypeElement type, String packageName) {
        int packageLen = packageName.length() + 1;
        return type.getQualifiedName().toString().substring(packageLen).replace('.', '$');
    }
}