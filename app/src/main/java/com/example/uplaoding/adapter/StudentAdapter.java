package com.example.uplaoding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uplaoding.R;
import com.example.uplaoding.bean.StudentBean;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<StudentBean.StudenlistDTO>list;

    public StudentAdapter(Context context, ArrayList<StudentBean.StudenlistDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StudentBean.StudenlistDTO studenlistDTO = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.tv_name.setText("姓名:"+studenlistDTO.getName());
        viewHolder.skill.setText("机试成绩"+studenlistDTO.getSkill()+"分");
        viewHolder.theory.setText("理论成绩"+studenlistDTO.getTheory()+"分");

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onLongClickListener.onLongClick(position);
                return true;
            }
        });

    }
    private OnLongClickListener onLongClickListener;

    public interface OnLongClickListener{
        void onLongClick(int position);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
            private TextView tv_name;
            private TextView skill;
            private TextView theory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            skill = itemView.findViewById(R.id.skill);
            theory = itemView.findViewById(R.id.theory);
        }
    }
}
