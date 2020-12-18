package com.example.uplaoding.contract;

import com.example.uplaoding.bean.StudentBean;
import com.example.uplaodinglibrary.base.BaseModel;
import com.example.uplaodinglibrary.base.BaseView;
import com.example.uplaodinglibrary.net.ImpCallBack;

public class StudentContract {

    public interface StudentView extends BaseView {
        void onSuccess(StudentBean studentBean);
        void onFail(String error);
    }

    public interface StudentModel extends BaseModel {
        <T> void studentModel(String url, ImpCallBack<T> callBack);
    }

    public interface StudentPresenter extends BaseView{
        void studentPresenter();
    }

}
