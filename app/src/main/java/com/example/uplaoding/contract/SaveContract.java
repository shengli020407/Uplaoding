package com.example.uplaoding.contract;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.bean.SaveBean;

public class SaveContract {

    public interface SaveView{
        void onSuccess(SaveBean saveBean);
        void onFail(String error);
    }

    public interface SaveModel{
        <T> void saveModel(String url, ImpCallBack<T>callBack);
    }

    public interface SavePresenter{
        void savePresenter();
    }

}
