package com.example.uplaoding.presenter;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.RetrofitUtils.net.Urlconstant;
import com.example.uplaoding.base.BasePresenter;
import com.example.uplaoding.bean.BannerBean;
import com.example.uplaoding.contract.MainContract;
import com.example.uplaoding.model.ImpMainModel;

public class ImpMainPresenter extends BasePresenter<MainContract.MainView,MainContract.MainModel> implements MainContract.MainPresenter {

    @Override
    public void mainPresenter() {
        iModel.mianModel(Urlconstant.BANLIST, new ImpCallBack<BannerBean>() {
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

    @Override
    protected MainContract.MainModel getiModel() {
        return new ImpMainModel(this);
    }
}
