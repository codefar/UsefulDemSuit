package com.meituan.davy.myapplication.github;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davy.demo.annotation.Demo;
import com.meituan.davy.myapplication.R;
import com.meituan.davy.myapplication.base.BaseFragment;
import com.meituan.davy.myapplication.base.BaseRecyclerFragment;
import com.meituan.davy.myapplication.bean.Contributor;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by davy on 2017/4/22.
 */
public class GithubFragment extends BaseFragment {

    @BindView(R.id.content_text)
    TextView mContentTextView;

    Call<List<Contributor>> call;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.text_view_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        call = mAppComponent.getGithubApi().contributors("square", "retrofit");
        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                mContentTextView.setText(Arrays.toString(response.body().toArray()));
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {
                mContentTextView.setText(t.getMessage());
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        call.cancel();
    }
}
