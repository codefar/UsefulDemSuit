package com.meituan.davy.myapplication.dagger.part1_inject;

import javax.inject.Inject;

public class Engine {

    @Inject
    Engine(){}

    public String run(){
        System.out.println("引擎转起来了~~~");
        return "引擎转起来了~~~";
    }
}