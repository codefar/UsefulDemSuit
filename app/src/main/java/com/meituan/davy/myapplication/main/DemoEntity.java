package com.meituan.davy.myapplication.main;

import com.meituan.davy.myapplication.db.DbFragment;

/**
 * Created by davy on 2017/4/22.
 */

public class DemoEntity {
    public String name;
    public String className;

    public DemoEntity(String name, String className) {
        this.name = name;
        this.className = className;
    }
}
