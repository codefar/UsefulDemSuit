package com.meituan.davy.myapplication.dagger.part1_inject;

import dagger.Component;

@Component
public interface CarComponent {
    void inject(Car car);
}