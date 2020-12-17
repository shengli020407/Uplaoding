package com.example.uplaoding.contract;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.bean.BannerBean;

public class MainContract {

    public interface MainView{
        void onSuccess(BannerBean bannerBean);
        void onFail(String error);
    }

    public interface MainModel{
        <T> void mianModel(String url, ImpCallBack<T>callBack);
    }

    public interface MainPresenter{
        void mainPresenter();
    }

}
