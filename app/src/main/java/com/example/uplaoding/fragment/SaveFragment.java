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
import com.example.uplaoding.bean.SaveBean;
import com.example.uplaoding.contract.SaveContract;
import com.example.uplaoding.presenter.ImpSavePresenter;

import java.util.ArrayList;

public class SaveFragment extends Fragment implements SaveContract.SaveView {

    private RecyclerView rec;
    private ArrayList<SaveBean.NewsDTO> list;
    private SaveAdapter adapter;
    private ImpSavePresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save, container, false);
        initView(view);
        initDate();
        return view;
    }

    private void initDate() {
        presenter = new ImpSavePresenter(this);
        presenter.savePresenter();
    }

    private void initView(View view) {
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