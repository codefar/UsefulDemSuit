package com.meituan.davy.myapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.davy.demo.annotation.Demo;
import com.facebook.stetho.Stetho;
import com.meituan.davy.demo_inject.DemoInjector;
import com.meituan.davy.myapplication.api.ApiModule;
import com.meituan.davy.myapplication.db.DBHelper;
import com.meituan.davy.myapplication.db.entity.User;
import com.meituan.davy.myapplication.db.entity.tomany.DaoSession;
import com.meituan.davy.myapplication.db.entity.toone.Customer;
import com.meituan.davy.myapplication.db.entity.toone.CustomerDao;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

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
        DemoInjector.init(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
