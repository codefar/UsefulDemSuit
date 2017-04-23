package com.meituan.davy.myapplication.main;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.AbsRecycleViewAdapter;
import com.meituan.davy.myapplication.dagger.Dagger2Fragment;
import com.meituan.davy.myapplication.db.DbFragment;
import com.meituan.davy.myapplication.list_swipe_delete.SwipeDeleteFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.list;

public class MainRecycleViewAdapter extends AbsRecycleViewAdapter<DemoEntity, MainRecycleViewAdapter.MainViewHolder> {

    class MainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView)
        TextView textView;
  
        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }  
    }  
  
    @Override  
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item_layout, parent, false);
        return new MainViewHolder(view);
    }  
  
    @Override  
    public void onBindViewHolder(final MainViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(holder, position, getItemId(position));
                }
                //Toast.makeText(view.getContext(), list.get(position).demoClass.getName() , Toast.LENGTH_LONG).show();
            }
        });
    }

    protected OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(MainViewHolder holder, int position, long id);
    }
}  