package com.example.uplaoding.model;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.RetrofitUtils.net.Utils;
import com.example.uplaoding.contract.StudentContract;

public class ImpStudentModel implements StudentContract.StudentModel {
    @Override
    public <T> void studentModel(String url, ImpCallBack<T> callBack) {
        Utils.getUtils().get(url,callBack);
    }
}
