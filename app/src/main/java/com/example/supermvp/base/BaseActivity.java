package com.example.supermvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<E> extends AppCompatActivity {

    protected AppCompatActivity mActivity;
    protected E mPrensenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        initView();
        mPrensenter = getPrensenter();
    }

    protected abstract E getPrensenter();

    protected abstract void initView();
}
