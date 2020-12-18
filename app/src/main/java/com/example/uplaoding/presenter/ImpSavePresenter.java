package com.example.uplaoding.presenter;

import com.example.uplaoding.bean.SaveBean;
import com.example.uplaoding.contract.SaveContract;
import com.example.uplaoding.model.ImpSaveModel;
import com.example.uplaodinglibrary.base.BasePresenter;
import com.example.uplaodinglibrary.net.ImpCallBack;
import com.example.uplaodinglibrary.net.Urlconstant;

public class ImpSavePresenter extends BasePresenter<SaveContract.SaveView,SaveContract.SaveModel> implements SaveContract.SavePresenter{


    @Override
    public void savePresenter() {
        iModel.saveModel(Urlconstant.SAVELIST, new ImpCallBack<SaveBean>() {
            @Override
            public void onSuccess(SaveBean saveBean) {
                iview.onSuccess(saveBean);
            }

            @Override
            public void onFail(String error) {
                iview.onFail(error);
            }
        });
    }

    @Override
    protected SaveContract.SaveModel getiModel() {
        return new ImpSaveModel(this);
    }



}
