package com.example.supermvp.presenter;

import android.annotation.SuppressLint;

import com.example.supermvp.base.BasePresenter;
import com.example.supermvp.base.BaseView;
import com.example.supermvp.model.MainModel;
import com.google.gson.JsonObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivityPresenter extends BasePresenter {
    private BaseView mView;
    private MainModel mainModel;

    public MainActivityPresenter() {
        mainModel = new MainModel();
    }

    @SuppressLint("CheckResult")
    public void getFirstData() {
        viewProxy.onLoad();
        mainModel.getFirstData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JsonObject>() {
                    @Override
                    public void accept(JsonObject jsonObject) throws Exception {
                        viewProxy.onSuccess(jsonObject);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        viewProxy.onError(new Exception(throwable.getMessage()));
                    }
                });
    }

    public void getSecondData() {
        viewProxy.onLoad();
        mainModel.getSecondData();
    }

    @Override
    public void attachView(BaseView view) {
        mView = view;
        generateProxyView(mView);
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
