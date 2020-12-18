package com.example.uplaoding.contract;

import com.example.uplaoding.bean.SaveBean;
import com.example.uplaodinglibrary.base.BaseModel;
import com.example.uplaodinglibrary.base.BaseView;
import com.example.uplaodinglibrary.net.ImpCallBack;

public class SaveContract {

    public interface SaveView extends BaseView {
        void onSuccess(SaveBean saveBean);
        void onFail(String error);
    }

    public interface SaveModel extends BaseModel {
        <T> void saveModel(String url, ImpCallBack<T> callBack);
    }

    public interface SavePresenter extends BaseView{
        void savePresenter();
    }

}
