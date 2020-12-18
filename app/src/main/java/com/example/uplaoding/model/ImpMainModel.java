package com.example.uplaoding.model;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.RetrofitUtils.net.Utils;
import com.example.uplaoding.contract.MainContract;
import com.example.uplaoding.presenter.ImpMainPresenter;

import retrofit2.Retrofit;

public class ImpMainModel implements MainContract.MainModel {

    private MainContract.MainPresenter presenter;

    public ImpMainModel(MainContract.MainPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void mianModel(String url, ImpCallBack<T> callBack) {
        Utils.getUtils().get(url,callBack);
    }
}
