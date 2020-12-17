package com.example.uplaoding.RetrofitUtils.net;

public interface ImpNetWorkInerface {

    public <T> void get(String url, ImpCallBack<T>callBack);

}
