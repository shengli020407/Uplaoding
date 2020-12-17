package com.example.uplaoding.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uplaoding.R;
import com.example.uplaoding.adapter.SaveAdapter;
import com.example.uplaoding.base.BaseFragment;
import com.example.uplaoding.bean.SaveBean;
import com.example.uplaoding.contract.SaveContract;
import com.example.uplaoding.presenter.ImpSavePresenter;

import java.util.ArrayList;

public class SaveFragment extends BaseFragment<SaveContract.SavePresenter> implements SaveContract.SaveView {

    private RecyclerView rec;
    private ArrayList<SaveBean.NewsDTO> list;
    private SaveAdapter adapter;
    private ImpSavePresenter presenter;


    protected void initDate() {
        presenter = new ImpSavePresenter(this);
        presenter.savePresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_save;
    }

    @Override
    protected SaveContract.SavePresenter getPresenter() {
        return presenter;
    }

    protected void initView(View view) {
        rec = view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new SaveAdapter(getContext(), list);
        rec.setAdapter(adapter);
    }

    @Override
    public void onSuccess(SaveBean saveBean) {
        list.addAll(saveBean.getNews());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Log.e("TAG",error);
    }
}