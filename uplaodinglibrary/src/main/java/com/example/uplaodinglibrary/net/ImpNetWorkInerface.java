package com.example.uplaodinglibrary.net;

public interface ImpNetWorkInerface {

    public <T> void get(String url, ImpCallBack<T>callBack);

}
