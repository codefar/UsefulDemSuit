package com.meituan.davy.myapplication.list_swipe_delete;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.AbsRecycleViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwipeDeleteRecycleViewAdapter extends AbsRecycleViewAdapter<String, SwipeDeleteRecycleViewAdapter.SwipeDeleteHolder> {

    class SwipeDeleteHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView textView;
        @BindView(R.id.swipe_root)
        SwipeLayout swipeLayout;
        @BindView(R.id.delete_menu)
        View delete;
  
        public SwipeDeleteHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
        }  
    }  
  
    @Override  
    public SwipeDeleteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_delete_item_layout, parent, false);
        return new SwipeDeleteHolder(view);
    }

    @Override  
    public void onBindViewHolder(final SwipeDeleteHolder holder, final int position) {
        holder.textView.setText(list.get(position));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }
}  