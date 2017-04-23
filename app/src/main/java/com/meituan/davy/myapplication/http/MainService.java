package com.meituan.davy.myapplication.http;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

public class MainService extends Service {

    private HttpServer mHttpServer = null;//这个是HttpServer的句柄。

    @Override
    public void onCreate() {
        //在这里开启HTTP Server。
        Log.d("HttpServer", "onCreate:");
        mHttpServer = new HttpServer(8092);
        try {
            mHttpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        //在这里关闭HTTP Server
        if (mHttpServer != null) {
            mHttpServer.stop();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}