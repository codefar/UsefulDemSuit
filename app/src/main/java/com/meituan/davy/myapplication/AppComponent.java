package com.meituan.davy.myapplication;

import android.app.Application;

import com.meituan.davy.myapplication.api.ApiModule;
import com.meituan.davy.myapplication.api.GitHubApi;
import com.meituan.davy.myapplication.api.RestApi;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class, ApiModule.class})
public interface AppComponent {
    Application getApplication();
    RestApi getService();
    GitHubApi getGithubApi();
}