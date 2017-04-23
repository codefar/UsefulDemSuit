package com.meituan.davy.myapplication.list_swipe_delete;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davy.demo.annotation.Demo;
import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.BaseFragment;
import com.meituan.davy.myapplication.data.DataSource;

import butterknife.BindView;

/**
 * A placeholder fragment containing a simple view.
 */
public class SwipeDeleteFragment extends BaseFragment {

    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;

    private SwipeDeleteRecycleViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());

        recyclerView.addItemDecoration(dividerItemDecoration);
        //设置动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置线性布局
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SwipeDeleteRecycleViewAdapter();
        recyclerView.setAdapter(adapter);
        adapter.addData(DataSource.datas);
    }
}
