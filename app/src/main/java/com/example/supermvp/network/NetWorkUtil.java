package com.example.supermvp.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkUtil {
    private Retrofit builder;

    private NetWorkUtil() {
    }

    public static class SingleHelper {
        private static NetWorkUtil mInstance = new NetWorkUtil();
    }

    public static NetWorkUtil getInstance() {
        return SingleHelper.mInstance;
    }


    public Retrofit createRetrofit() {
        if (builder == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();
            builder = new Retrofit.Builder()
                    .baseUrl(NetService.API)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return builder;
    }

}
