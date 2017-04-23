package com.meituan.davy.myapplication.base;

import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.meituan.davy.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class AbsRecycleViewAdapter<T, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<H> {

    protected List<T> list = new ArrayList<>();

    public AbsRecycleViewAdapter(){
    }

    @Override
    public H onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(H holder, int position) {

    }

    @Override
    public int getItemCount() {  
        return list.size();  
    }

    public void addData(T data) {
        list.add(data);
        notifyDataSetChanged();
    }

    public void addData(T[] data) {
        list.addAll(Arrays.asList(data));
        notifyDataSetChanged();
    }

    public void addData(List<T> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }
}  