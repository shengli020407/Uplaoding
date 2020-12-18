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
import com.example.uplaoding.presenter.ImpSavePresenter;
import com.example.uplaoding.presenter.ImpStudentPresenter;
import com.example.uplaodinglibrary.base.BaseFragment;

import java.util.ArrayList;

public class StudentFragment extends BaseFragment<ImpStudentPresenter> implements StudentContract.StudentView {

    private RecyclerView rec;
    private ArrayList<StudentBean.StudenlistDTO> list;
    private StudentAdapter studentAdapter;


    protected void initDate() {
        presenter.studentPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_student;
    }

    @Override
    protected ImpStudentPresenter getPresenter() {
        return new ImpStudentPresenter();
    }

    protected void initView(View view) {
        rec = view.findViewById(R.id.rec);
        rec.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        studentAdapter = new StudentAdapter(getContext(), list);
        rec.setAdapter(studentAdapter);

        studentAdapter.setOnLongClickListener(new StudentAdapter.OnLongClickListener() {
            @Override
            public void onLongClick(int position) {
                list.remove(position);
                studentAdapter.notifyDataSetChanged();
            }
        });
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