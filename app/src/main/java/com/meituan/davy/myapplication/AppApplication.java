package com.meituan.davy.myapplication;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.meituan.davy.myapplication.api.ApiModule;

/**
 * Created by davy on 2017/4/19.
 */
public class AppApplication extends Application {

    private AppComponent appComponent;

    public static AppApplication get(Context context){
        return (AppApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // DaggerAPPComponent是在正确配置了Module和APPComponent之后，再BuildProject之后会自动生成。APPComponent依赖了多少个Module在Builder的时候就需要注入多少Module
        appComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .mainModule(new MainModule(this))
                .build();
        Stetho.initializeWithDefaults(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
