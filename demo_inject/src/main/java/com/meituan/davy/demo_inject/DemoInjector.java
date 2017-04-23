package com.meituan.davy.demo_inject;

import android.app.Activity;
import android.content.Context;

import com.davy.demo.annotation.DemoClassName;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by davy on 2017/4/23.
 */

public class DemoInjector {

    public static Map<String, String> demos = new HashMap<>();

    public static void init(Context context) {
        //String pakName = context.getPackageName();
        //System.out.println(pakName);
        try {
            Class clazz = Class.forName(DemoClassName.DEMO_PKG_NAME + "." + DemoClassName.DEMO_CLASS_NAME);
            //System.out.println(clazz.getName());
            Field[] fields = clazz.getFields();
            //System.out.println(fields.length);

            try {
                Field demoField = clazz.getField("demos");
                demoField.setAccessible(true);
                System.out.println(demos);
                HashMap<String, String> maps = (HashMap<String, String>) demoField.get(clazz);
                System.out.println(maps);
                demos.putAll(maps);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
