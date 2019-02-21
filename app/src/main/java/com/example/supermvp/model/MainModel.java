package com.example.supermvp.model;

import com.example.supermvp.network.ServiceProvider;
import com.google.gson.JsonObject;

import io.reactivex.Flowable;

public class MainModel {

    public MainModel() {
    }

    public Flowable<JsonObject> getFirstData() {
        return ServiceProvider.getInstance().createRetrofit().getMainActivityData();
    }

    public void getSecondData() {

    }
}
