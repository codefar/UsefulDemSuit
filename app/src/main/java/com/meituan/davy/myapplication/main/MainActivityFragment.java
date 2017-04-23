package com.meituan.davy.myapplication.main;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment {

    @BindView(R.id.recycle_view)
    RecyclerView recyclerView;

    private MainRecycleViewAdapter adapter;

    private final List<DemoEntity> list = new ArrayList<>();

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        List<ResolveInfo> infos = getContext().getPackageManager().queryIntentActivities(new Intent("com.meituan.davy.myapplicatio.DEMO"), 0);
        for (ResolveInfo info : infos) {
            list.add(new DemoEntity(info.activityInfo.loadLabel(getActivity().getPackageManager()).toString(), info.activityInfo.name));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());

        recyclerView.addItemDecoration(dividerItemDecoration);
        //设置动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置线性布局
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MainRecycleViewAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new MainRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(MainRecycleViewAdapter.MainViewHolder holder, int position, long id) {
                Intent intent = new Intent();
                intent.setClassName(getContext().getPackageName(), list.get(position).className);
                startActivity(intent);
            }
        });
        adapter.addData(list);
    }
}
