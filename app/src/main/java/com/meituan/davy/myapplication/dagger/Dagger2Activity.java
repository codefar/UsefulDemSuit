package com.meituan.davy.myapplication.dagger;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.meituan.davy.myapplication.ContainerActivity;
import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.BaseActiivity;

public class Dagger2Activity extends ContainerActivity {
    @Override
    protected Fragment getFragment() {
        return new Dagger2Fragment();
    }
}
