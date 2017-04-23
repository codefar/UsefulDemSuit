package com.meituan.davy.myapplication.list_swipe_delete;

import android.support.v4.app.Fragment;

import com.meituan.davy.myapplication.ContainerActivity;

public class SwipeDeleteActivity extends ContainerActivity {
    @Override
    protected Fragment getFragment() {
        return new SwipeDeleteFragment();
    }
}