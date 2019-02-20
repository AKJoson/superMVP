package com.example.supermvp.listener;

public interface BaseView<T> {
    void onLoad();

    void onSuccess(T data);

    void onError(Exception e);
}
