package com.example.supermvp.base;

public interface IPresenter {
    void attachView(BaseView view);

    void detachView();
}
