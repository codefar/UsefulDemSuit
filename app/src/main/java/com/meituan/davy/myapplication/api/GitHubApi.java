package com.meituan.davy.myapplication.api;

import com.meituan.davy.myapplication.bean.Contributor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {

    public static final String API_BASE_URL = "https://api.github.com";

    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(
        @Path("owner") String owner,
        @Path("repo") String repo);
  }
