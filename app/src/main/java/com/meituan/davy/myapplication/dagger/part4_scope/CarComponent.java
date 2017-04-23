package com.meituan.davy.myapplication.dagger.part4_scope;

import dagger.Component;

@CarScope
@Component(modules = {MarkCarModule.class})
public interface CarComponent {
    void inject(Car car);
}