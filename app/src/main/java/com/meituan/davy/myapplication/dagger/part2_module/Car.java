package com.meituan.davy.myapplication.dagger.part2_module;

import com.meituan.davy.myapplication.dagger.part2_module.DaggerCarComponent;

import javax.inject.Inject;

public class Car {

    @Inject
    Engine engine;

    public Car() {
        DaggerCarComponent.builder().markCarModule(new MarkCarModule()).build().inject(this);
    }

    public Engine getEngine() {
        return this.engine;
    }
}