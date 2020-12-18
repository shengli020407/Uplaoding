package com.example.uplaoding.presenter;

import com.example.uplaoding.RetrofitUtils.net.ImpCallBack;
import com.example.uplaoding.RetrofitUtils.net.Urlconstant;
import com.example.uplaoding.base.BasePresenter;
import com.example.uplaoding.bean.SaveBean;
import com.example.uplaoding.contract.SaveContract;
import com.example.uplaoding.model.ImpSaveModel;

public class ImpSavePresenter implements SaveContract.SavePresenter {

    public SaveContract.SaveModel model;
    public SaveContract.SaveView saveView;

    public ImpSavePresenter(SaveContract.SaveView saveView) {
        this.saveView = saveView;
        model = new ImpSaveModel();
    }


    @Override
    public void savePresenter() {
        model.saveModel(Urlconstant.SAVELIST, new ImpCallBack<SaveBean>() {
            @Override
            public void onSuccess(SaveBean saveBean) {
                saveView.onSuccess(saveBean);
            }

            @Override
            public void onFail(String error) {
                saveView.onFail(error);
            }
        });
    }
}
