package com.example.supermvp.presenter;

import android.annotation.SuppressLint;
import android.os.Handler;

import com.example.supermvp.base.BasePresenter;
import com.example.supermvp.listener.BaseView;
import com.example.supermvp.model.MainModel;
import com.google.gson.JsonObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class MainActivityPresenter implements BasePresenter {
    private BaseView mView;
    private final MainModel mainModel;

    public MainActivityPresenter(BaseView view) {
        mView = view;
        //create the Model , to control data.
        mainModel = new MainModel();
    }

    @SuppressLint("CheckResult")
    public void getFirstData() {
        mView.onLoad();
        mainModel.getFirstData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JsonObject>() {
                    @Override
                    public void accept(JsonObject jsonObject) throws Exception {
                        mView.onSuccess(jsonObject.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(new Exception(throwable.getMessage()));
                    }
                });
    }

    public void getSecondData() {
        mView.onLoad();
        mainModel.getSecondData();
    }

    @Override
    public void attachView(BaseView view) {
        mView = view;
    }


    @Override
    public void detachView() {
        mView = null;
    }
}
