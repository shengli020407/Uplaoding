package com.example.uplaoding.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T> extends AppCompatActivity {

    private T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        if (presenter==null){
            presenter=getPresenter();
        }

        initView();
        initDate();
    }

    protected abstract void  initView();

    protected abstract void  initDate();

    protected abstract T getPresenter();

    protected abstract int getLayout();

}
