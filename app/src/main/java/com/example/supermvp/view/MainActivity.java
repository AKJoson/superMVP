package com.example.supermvp.view;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supermvp.R;
import com.example.supermvp.base.BaseActivity;
import com.example.supermvp.listener.BaseView;
import com.example.supermvp.presenter.MainActivityPresenter;

/**
 * practice MVP pattern.
 */
public class MainActivity extends BaseActivity<MainActivityPresenter> implements BaseView<String> {

    private Button button;
    private TextView textView;

    @Override
    protected MainActivityPresenter getPrensenter() {
        return new MainActivityPresenter(this);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.start_button);
        textView = findViewById(R.id.text_content);
        initClick();
    }

    private void initClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPrensenter.getFirstData();
            }
        });
    }

    @Override
    public void onLoad() {
        Toast.makeText(mActivity, "start to load data,please wait...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String data) {
        //  Toast.makeText(mActivity, "load data success."+data, Toast.LENGTH_SHORT).show();
        textView.setText(data);
    }

    @Override
    public void onError(Exception e) {
        Toast.makeText(mActivity, "load data error." + e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
