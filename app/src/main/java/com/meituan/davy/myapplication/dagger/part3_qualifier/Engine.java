package com.meituan.davy.myapplication.dagger.part3_qualifier;

import javax.inject.Inject;

public class Engine {

    private String gear;

    public Engine(String gear) {
        this.gear = gear;
    }

    public String run(){
        System.out.println(gear + "引擎转起来了~~~");
        return gear + "引擎转起来了~~~";
    }
}