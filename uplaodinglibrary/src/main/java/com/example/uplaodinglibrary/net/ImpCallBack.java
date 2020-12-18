package com.example.uplaodinglibrary.net;

public interface ImpCallBack<T> {

    public void onSuccess(T t);

    public void onFail(String error);

}
