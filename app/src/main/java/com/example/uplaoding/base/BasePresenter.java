package com.example.uplaoding.base;

public class BasePresenter<V extends BaseView> {

    public V iview;

    public void attachview(V v){
        iview=v;
    }

}
