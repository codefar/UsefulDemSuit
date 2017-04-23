package com.meituan.davy.myapplication.flexboxlayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.meituan.davy.myapplication.ContainerActivity;
import com.meituan.davy.myapplication.db.DbFragment;

public class FlexBoxActivity extends ContainerActivity {
    @Override
    protected Fragment getFragment() {
        return new FlexboxLayoutFragement();
    }
}
