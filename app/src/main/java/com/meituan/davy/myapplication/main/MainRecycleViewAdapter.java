package com.meituan.davy.myapplication.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.AbsRecycleViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


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