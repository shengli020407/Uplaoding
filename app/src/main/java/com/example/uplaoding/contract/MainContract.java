package com.example.uplaoding.contract;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.base.BaseModel;
import com.example.uplaoding.base.BaseView;
import com.example.uplaoding.bean.BannerBean;

public class MainContract {

    public interface MainView extends BaseView {
        void onSuccess(BannerBean bannerBean);
        void onFail(String error);
    }

    public interface MainModel extends BaseModel {
        <T> void mianModel(String url, ImpCallBack<T>callBack);
    }

    public interface MainPresenter extends BaseView{
        void mainPresenter();
    }

}
