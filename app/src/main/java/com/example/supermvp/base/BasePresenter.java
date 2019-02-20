package com.example.supermvp.base;


import com.example.supermvp.listener.BaseView;

public interface BasePresenter {

    void attachView(BaseView view);

    void detachView();

}
