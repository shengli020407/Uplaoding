package com.example.uplaodinglibrary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{

    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        if (presenter==null){
            presenter=getPresenter();
            presenter.attachview(this);
        }

        initView();
        initDate();
    }

    protected abstract void  initView();

    protected abstract void  initDate();

    protected abstract int getLayout();

    public abstract T getPresenter();

}
