package com.example.uplaoding.model;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.RetrofitUtils.net.Utils;
import com.example.uplaoding.contract.SaveContract;

public class ImpSaveModel implements SaveContract.SaveModel {
    @Override
    public <T> void saveModel(String url, ImpCallBack<T> callBack) {
        Utils.getUtils().get(url,callBack);
    }
}
