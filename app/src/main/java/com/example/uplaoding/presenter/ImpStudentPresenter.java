package com.example.uplaoding.presenter;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.RetrofitUtils.net.Urlconstant;
import com.example.uplaoding.bean.StudentBean;
import com.example.uplaoding.contract.StudentContract;
import com.example.uplaoding.model.ImpStudentModel;

public class ImpStudentPresenter implements StudentContract.StudentPresenter {

    private StudentContract.StudentView studentView;
    private final ImpStudentModel model;

    public ImpStudentPresenter(StudentContract.StudentView studentView) {
        this.studentView = studentView;
        model = new ImpStudentModel();
    }

    @Override
    public void studentPresenter() {
        model.studentModel(Urlconstant.STUDENTLIST, new ImpCallBack<StudentBean>() {
            @Override
            public void onSuccess(StudentBean studentBean) {
                studentView.onSuccess(studentBean);
            }

            @Override
            public void onFail(String error) {
                studentView.onFail(error);
            }
        });
    }
}
