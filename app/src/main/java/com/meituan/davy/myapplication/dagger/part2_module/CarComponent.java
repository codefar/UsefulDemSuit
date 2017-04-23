package com.meituan.davy.myapplication.dagger.part2_module;

import dagger.Component;

@Component(modules = {MarkCarModule.class})
public interface CarComponent {
    void inject(Car car);
}