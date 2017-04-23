package com.meituan.davy.myapplication.db;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by davy on 2017/4/22.
 */
public class DbFragment extends BaseFragment {

    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_db, container, false);
    }
}
