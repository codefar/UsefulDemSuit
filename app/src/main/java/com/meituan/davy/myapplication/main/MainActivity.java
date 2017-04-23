package com.meituan.davy.myapplication.main;

import android.os.Bundle;

import com.davy.demo.annotation.AutoCreate;
import com.davy.demo.annotation.Demo;
import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.BaseActiivity;

@Demo(name = "Main")
@AutoCreate
public class MainActivity extends BaseActiivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected int gerLayoutRes() {
        return R.layout.activity_main;
    }
}
