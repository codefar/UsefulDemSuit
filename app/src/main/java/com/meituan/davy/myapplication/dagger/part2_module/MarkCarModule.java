package com.meituan.davy.myapplication.dagger.part2_module;

import dagger.Module;
import dagger.Provides;

@Module
public class MarkCarModule {

    public MarkCarModule(){
    }

    @Provides
    Engine provideEngineA(){
        return new Engine("gear");
    }
}