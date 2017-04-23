package com.meituan.davy.myapplication.base;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meituan.davy.myapplication.AppApplication;
import com.meituan.davy.myapplication.AppComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by davy on 2017/4/22.
 */

public class BaseFragment extends Fragment {

    private Unbinder unbinder;
    protected AppComponent mAppComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAppComponent = AppApplication.get(getActivity()).getAppComponent();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
