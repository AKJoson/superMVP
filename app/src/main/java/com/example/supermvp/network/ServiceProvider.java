package com.example.supermvp.network;

public class ServiceProvider {
    private volatile static ServiceProvider mInstance;

    private ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        if (mInstance == null) {
            synchronized (ServiceProvider.class) {
                if (mInstance == null) {
                    mInstance = new ServiceProvider();
                }
            }
        }
        return mInstance;
    }

    public NetService createRetrofit() {
        return NetWorkUtil.getInstance().createRetrofit().create(NetService.class);
    }
}
