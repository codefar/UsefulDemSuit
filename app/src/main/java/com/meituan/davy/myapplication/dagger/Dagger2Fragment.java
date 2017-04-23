package com.meituan.davy.myapplication.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davy.demo.annotation.Demo;
import com.meituan.davy.myapplication.base.BaseFragment;
import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.dagger.part4_scope.Car;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * http://blog.csdn.net/baron_leizhang/article/details/59532530
 * Created by davy on 2017/4/22.
 */
public class Dagger2Fragment extends BaseFragment {

    @BindView(R.id.content_text)
    TextView mContentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dagger2, container, false);
    }

    @OnClick(R.id.button)
    public void submit(View view) {
        com.meituan.davy.myapplication.dagger.part1_inject.Car car1 = new com.meituan.davy.myapplication.dagger.part1_inject.Car();
        com.meituan.davy.myapplication.dagger.part2_module.Car car2 = new com.meituan.davy.myapplication.dagger.part2_module.Car();
        com.meituan.davy.myapplication.dagger.part3_qualifier.Car car3 = new com.meituan.davy.myapplication.dagger.part3_qualifier.Car();
        Car car4 = new Car();
        mContentView.append(car1.getEngine().run() + "\n");
        mContentView.append(car2.getEngine().run() + "\n");
        mContentView.append(car3.getEngineA().run()+ "\n");
        mContentView.append(car3.getEngineB().run()+ "\n");

        mContentView.append(car4.getEngineA().hashCode()+ "\n");
        mContentView.append(car4.getEngineB().hashCode()+ "\n");
    }
}
