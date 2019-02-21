package com.example.supermvp.base;

public interface BaseView<T> {
    void onLoad();

    void onSuccess(T data);

    void onError(Exception e);
}
