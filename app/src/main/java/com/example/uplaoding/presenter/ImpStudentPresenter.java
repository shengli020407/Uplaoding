package com.example.uplaoding.presenter;

import com.example.uplaoding.bean.StudentBean;
import com.example.uplaoding.contract.StudentContract;
import com.example.uplaoding.model.ImpStudentModel;
import com.example.uplaodinglibrary.base.BasePresenter;
import com.example.uplaodinglibrary.net.ImpCallBack;
import com.example.uplaodinglibrary.net.Urlconstant;

public class ImpStudentPresenter extends BasePresenter<StudentContract.StudentView,StudentContract.StudentModel> implements StudentContract.StudentPresenter {


    @Override
    public void studentPresenter() {
        iModel.studentModel(Urlconstant.STUDENTLIST, new ImpCallBack<StudentBean>() {
            @Override
            public void onSuccess(StudentBean studentBean) {
                iview.onSuccess(studentBean);
            }

            @Override
            public void onFail(String error) {
                iview.onFail(error);
            }
        });
    }

    @Override
    protected StudentContract.StudentModel getiModel() {
        return new ImpStudentModel(this);
    }
}
