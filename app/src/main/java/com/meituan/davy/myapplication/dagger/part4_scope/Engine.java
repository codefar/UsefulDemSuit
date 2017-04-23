package com.meituan.davy.myapplication.dagger.part4_scope;

public class Engine {

    private String gear;

    public Engine(String gear){
        System.out.println("Create Engine");
        this.gear = gear;
    }
}