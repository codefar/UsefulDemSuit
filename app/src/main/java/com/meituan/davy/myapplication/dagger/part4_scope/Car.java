package com.meituan.davy.myapplication.dagger.part4_scope;

import javax.inject.Inject;

public class Car {

    @Inject Engine engineA;
    @Inject Engine engineB;

    public Car() {
        DaggerCarComponent.builder()
                .markCarModule(new MarkCarModule())
                .build().inject(this);
    }

    public Engine getEngineA() {
        return engineA;
    }

    public Engine getEngineB() {
        return engineB;
    }
}