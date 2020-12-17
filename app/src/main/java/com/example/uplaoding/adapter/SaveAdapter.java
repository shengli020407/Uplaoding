package com.example.uplaoding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.uplaoding.R;
import com.example.uplaoding.bean.SaveBean;

import java.util.ArrayList;

public class SaveAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<SaveBean.NewsDTO>list;

    public SaveAdapter(Context context, ArrayList<SaveBean.NewsDTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_save, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SaveBean.NewsDTO newsDTO = list.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.title.setText(newsDTO.getTile());
        viewHolder.desc.setText(newsDTO.getContent());
        Glide.with(context).load(newsDTO.getImageUrl()).into(viewHolder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView image;
            private TextView title;
            private TextView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             image = (ImageView)itemView.findViewById(R.id.image);
             title = (TextView)itemView.findViewById(R.id.title);
             desc = (TextView) itemView.findViewById(R.id.desc);
        }
    }
}
