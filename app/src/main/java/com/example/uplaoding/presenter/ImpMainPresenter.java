package com.example.uplaoding.presenter;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.RetrofitUtils.net.Urlconstant;
import com.example.uplaoding.bean.BannerBean;
import com.example.uplaoding.contract.MainContract;
import com.example.uplaoding.model.ImpMainModel;

public class ImpMainPresenter implements MainContract.MainPresenter {
    private MainContract.MainView mainView;
    private final ImpMainModel model;

    public ImpMainPresenter(MainContract.MainView mainView) {
        this.mainView = mainView;
        model = new ImpMainModel();
    }

    @Override
    public void mainPresenter() {
        model.mianModel(Urlconstant.BANLIST, new ImpCallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                mainView.onSuccess(bannerBean);
            }

            @Override
            public void onFail(String error) {
                mainView.onFail(error);
            }
        });
    }
}
