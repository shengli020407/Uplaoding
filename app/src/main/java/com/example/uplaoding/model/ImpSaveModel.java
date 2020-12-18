package com.example.uplaoding.model;

import com.example.uplaoding.contract.SaveContract;
import com.example.uplaodinglibrary.net.ImpCallBack;
import com.example.uplaodinglibrary.net.Utils;

public class ImpSaveModel implements SaveContract.SaveModel {

    private SaveContract.SavePresenter presenter;

    public ImpSaveModel(SaveContract.SavePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void saveModel(String url, ImpCallBack<T> callBack) {
        Utils.getUtils().get(url,callBack);
    }
}
