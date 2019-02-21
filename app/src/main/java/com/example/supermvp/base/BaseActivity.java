package com.example.supermvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<E extends BasePresenter,T> extends AppCompatActivity  implements BaseView<T>{

    protected AppCompatActivity mActivity;
    protected E mPrensenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        initView();
        mPrensenter = getPresenter();
        mPrensenter.attachView(this);
        initClick();
    }

    protected abstract void initClick();

    protected abstract E getPresenter();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPrensenter != null)
            mPrensenter.detachView();
    }
}
