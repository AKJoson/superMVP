package com.example.supermvp.view;


import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supermvp.R;
import com.example.supermvp.base.BaseActivity;
import com.example.supermvp.base.BaseAdapter;
import com.example.supermvp.base.BaseViewHolder;
import com.example.supermvp.model.MainDataBean;
import com.example.supermvp.presenter.MainActivityPresenter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * practice MVP pattern.
 */
public class MainActivity extends BaseActivity<MainActivityPresenter, JsonObject> implements View.OnClickListener {

    private Button button;
    private RecyclerView recyclerView;
    private BaseAdapter<MainDataBean.DataBean> adapter;

    @Override
    protected MainActivityPresenter getPresenter() {
        return new MainActivityPresenter();
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.start_button);
        recyclerView = findViewById(R.id.recycler_view);
        adapter = new BaseAdapter<MainDataBean.DataBean>(new ArrayList<MainDataBean.DataBean>(), R.layout.item_layout) {
            @Override
            protected void bindHolder(BaseViewHolder baseViewHolder, MainDataBean.DataBean dataBean, int i) {
                ((TextView) baseViewHolder.getItemView().findViewById(R.id.item_text_name)).setText(dataBean.getName());
                ((TextView) baseViewHolder.getItemView().findViewById(R.id.item_text_name)).setTag(R.id.item_text_name, dataBean);
                ((TextView) baseViewHolder.getItemView().findViewById(R.id.item_text_name)).setOnClickListener(MainActivity.this);
                ((TextView) baseViewHolder.getItemView().findViewById(R.id.item_text_order)).setText(String.valueOf(dataBean.getOrder()));
            }
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPrensenter.getFirstData();
            }
        });
    }

    @Override
    public void onLoad() {
        Log.e("TAG", "onLoad....");
        Toast.makeText(mActivity, "start to load data,please wait...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(JsonObject data) {
        MainDataBean mainDataBean = new Gson().fromJson(data, MainDataBean.class);
        if (mainDataBean.getErrorCode() == 0)
            adapter.updateData(mainDataBean.getData());
        else
            onError(new Exception("response error."));
    }

    @Override
    public void onError(Exception e) {
        Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_text_name:
                MainDataBean.DataBean dataBean = (MainDataBean.DataBean) v.getTag(R.id.item_text_name);
                Toast.makeText(mActivity, "you click " + dataBean
                        .getName(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
