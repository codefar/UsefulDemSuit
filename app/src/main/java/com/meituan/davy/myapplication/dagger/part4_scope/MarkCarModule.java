package com.meituan.davy.myapplication.dagger.part4_scope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MarkCarModule {

    @Singleton
    public MarkCarModule() {
    }

    @Provides
    @CarScope
    Engine provideEngine() {
        return new Engine("gear");
    }
}