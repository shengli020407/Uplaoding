package com.example.uplaoding.model;

import com.example.uplaoding.contract.StudentContract;
import com.example.uplaodinglibrary.net.ImpCallBack;
import com.example.uplaodinglibrary.net.Utils;

public class ImpStudentModel implements StudentContract.StudentModel {
    public StudentContract.StudentPresenter presenter;

    public ImpStudentModel(StudentContract.StudentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void studentModel(String url, ImpCallBack<T> callBack) {
        Utils.getUtils().get(url,callBack);
    }
}
