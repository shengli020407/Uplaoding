package com.example.uplaoding.RetrofitUtils.net;

public interface ImpCallBack<T> {

    public void onSuccess(T t);

    public void onFail(String error);

}
