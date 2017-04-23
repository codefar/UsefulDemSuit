package com.meituan.davy.myapplication.github;

import android.support.v4.app.Fragment;

import com.meituan.davy.myapplication.ContainerActivity;

public class GithubActivity extends ContainerActivity {
    @Override
    protected Fragment getFragment() {
        return new GithubFragment();
    }
}