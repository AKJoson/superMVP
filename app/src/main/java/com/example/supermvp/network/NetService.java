package com.example.supermvp.network;

import com.google.gson.JsonObject;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Retrofit network interface.
 */
public interface NetService {

    String API = "http://wanandroid.com/";

    @GET("wxarticle/chapters/json")
    Flowable<JsonObject> getMainActivityData();

}
