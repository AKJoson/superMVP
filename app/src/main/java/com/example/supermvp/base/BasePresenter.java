package com.example.supermvp.base;


import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class BasePresenter implements IPresenter {
    protected BaseView viewProxy;

    public void generateProxyView(final BaseView mView) {
        viewProxy = (BaseView) Proxy.newProxyInstance(BaseView.class.getClassLoader(), new Class[]{BaseView.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object object = null;
                Log.e("TAG", "开始使用反射大法了哟~~");
                if (mView != null) //其实这个判断空 就是用来统一的:当app已经被干掉，这个时候，子线程中请求回来的数据，不必再进行加载。
                    object = method.invoke(mView, args);
                Log.e("TAG", "反射大法结束~~");
                return object;
            }
        });
    }
}
