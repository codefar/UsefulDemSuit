package com.meituan.davy.myapplication.db;

import android.support.v4.app.Fragment;

import com.meituan.davy.myapplication.ContainerActivity;
import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.BaseActiivity;

public class GreenDaoActivity extends ContainerActivity {
    @Override
    protected Fragment getFragment() {
        return new DbFragment();
    }
}
