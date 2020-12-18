package com.example.uplaoding.contract;


import com.example.uplaoding.bean.BannerBean;
import com.example.uplaodinglibrary.base.BaseModel;
import com.example.uplaodinglibrary.base.BaseView;
import com.example.uplaodinglibrary.net.ImpCallBack;

public class MainContract {

    public interface MainView extends BaseView {
        void onSuccess(BannerBean bannerBean);
        void onFail(String error);
    }

    public interface MainModel extends BaseModel {
        <T> void mianModel(String url, ImpCallBack<T> callBack);
    }

    public interface MainPresenter extends BaseView {
        void mainPresenter();
    }

}
