package com.example.uplaodinglibrary.base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {

    public V iview;

    public M iModel;

    public void attachview(V v){
        iview=v;
        iModel=getiModel();
    }

    protected abstract M getiModel();

}
