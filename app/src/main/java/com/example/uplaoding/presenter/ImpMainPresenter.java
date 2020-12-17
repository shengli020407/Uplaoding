package com.example.uplaoding.presenter;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.RetrofitUtils.net.Urlconstant;
import com.example.uplaoding.base.BasePresenter;
import com.example.uplaoding.bean.BannerBean;
import com.example.uplaoding.contract.MainContract;
import com.example.uplaoding.model.ImpMainModel;

public class ImpMainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.MainPresenter {


    public  MainContract.MainModel model;

    public ImpMainPresenter(){
        this.model = new ImpMainModel();
    }

    @Override
    public void mainPresenter() {
        model.mianModel(Urlconstant.BANLIST, new ImpCallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                iview.onSuccess(bannerBean);
            }

            @Override
            public void onFail(String error) {
                iview.onFail(error);
            }
        });
    }
}
