package com.meituan.davy.myapplication.dagger.part1_inject;

import com.meituan.davy.myapplication.dagger.part1_inject.DaggerCarComponent;

import javax.inject.Inject;

public class Car {

    @Inject
    Engine engine;

    public Car() {
        DaggerCarComponent.builder().build().inject(this);
    }

    public Engine getEngine() {
        return this.engine;
    }
}