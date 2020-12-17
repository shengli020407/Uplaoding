package com.example.uplaoding.contract;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.bean.SaveBean;
import com.example.uplaoding.bean.StudentBean;

public class StudentContract {

    public interface StudentView{
        void onSuccess(StudentBean studentBean);
        void onFail(String error);
    }

    public interface StudentModel{
        <T> void studentModel(String url, ImpCallBack<T> callBack);
    }

    public interface StudentPresenter{
        void studentPresenter();
    }

}
