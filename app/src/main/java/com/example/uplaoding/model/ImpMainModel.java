package com.example.uplaoding.model;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.RetrofitUtils.net.Utils;
import com.example.uplaoding.contract.MainContract;

import retrofit2.Retrofit;

public class ImpMainModel implements MainContract.MainModel {
    @Override
    public <T> void mianModel(String url, ImpCallBack<T> callBack) {
        Utils.getUtils().get(url,callBack);
    }
}
