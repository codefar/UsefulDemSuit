package com.meituan.davy.myapplication.dagger.part3_qualifier;

import dagger.Component;

@Component(modules = {MarkCarModule.class})
public interface CarComponent {
    void inject(Car car);
}