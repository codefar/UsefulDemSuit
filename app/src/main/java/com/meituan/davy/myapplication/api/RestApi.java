package com.meituan.davy.myapplication.api;

import android.database.Observable;

import com.meituan.davy.myapplication.bean.RepoModel;
import com.meituan.davy.myapplication.bean.UserModel;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {

    public static final String API_BASE_URL = "https://api.github.com";

    // 获取库, 获取的是一组RepoModel数据
    @GET("/users/{user}/repos")
    Observable<ArrayList<RepoModel>> getRepoData(@Path("user") String user);

    // 获取是单个UserModel
    @GET("/users/{user}")
    Observable<UserModel> getUserData(@Path("user") String user);

}