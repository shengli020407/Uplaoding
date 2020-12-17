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
import com.example.uplaoding.adapter.StudentAdapter;
import com.example.uplaoding.bean.StudentBean;
import com.example.uplaoding.contract.StudentContract;
import com.example.uplaoding.presenter.ImpStudentPresenter;

import java.util.ArrayList;

public class StudentFragment extends Fragment implements StudentContract.StudentView {

    private RecyclerView rec;
    private ArrayList<StudentBean.StudenlistDTO> list;
    private StudentAdapter studentAdapter;
    private ImpStudentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        initView(view);
        initDate();
        return view;

    }

    private void initDate() {
        presenter = new ImpStudentPresenter(this);
        presenter.studentPresenter();
    }

    private void initView(View view) {
        rec = view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        studentAdapter = new StudentAdapter(getContext(), list);
        rec.setAdapter(studentAdapter);
    }

    @Override
    public void onSuccess(StudentBean studentBean) {
        list.addAll(studentBean.getStudenlist());
        studentAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Log.e("TAG",error);
    }
}