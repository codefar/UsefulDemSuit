package com.meituan.davy.myapplication.dagger.part3_qualifier;

import com.meituan.davy.myapplication.dagger.part3_qualifier.Engine;
import com.meituan.davy.myapplication.dagger.part3_qualifier.QualifierA;
import com.meituan.davy.myapplication.dagger.part3_qualifier.QualifierB;

import dagger.Module;
import dagger.Provides;

@Module
public class MarkCarModule {

    public MarkCarModule(){
    }

    @QualifierA
    @Provides
    Engine provideEngineA(){
        return new Engine("gearA");
    }

    @QualifierB
    @Provides
    Engine provideEngineB(){
        return new Engine("gearB");
    }
}