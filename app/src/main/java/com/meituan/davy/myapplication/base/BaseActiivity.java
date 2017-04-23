package com.meituan.davy.myapplication.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.meituan.davy.myapplication.AppApplication;
import com.meituan.davy.myapplication.AppComponent;
import com.meituan.davy.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActiivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(gerLayoutRes());
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initTitleBar();
        initComponent(AppApplication.get(this).getAppComponent());
    }

    protected void initComponent(AppComponent appComponent) {

    }

    protected abstract @LayoutRes int gerLayoutRes();

    public void initTitleBar() {
    }
}