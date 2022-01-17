package com.example.a5_recyclerviewinsiderecyclerviewjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a5_recyclerviewinsiderecyclerviewjava.R;
import com.example.a5_recyclerviewinsiderecyclerviewjava.model.MemberSub;

import java.util.List;

public class CustomSubAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<MemberSub> memberSubList;
    public CustomSubAdapter(Context context, List<MemberSub> memberSubList){
        this.context = context;
        this.memberSubList = memberSubList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_view_list, parent, false);
        return new CustomViewSub(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MemberSub memberSub = memberSubList.get(position);
    }

    @Override
    public int getItemCount() {
        return memberSubList.size();
    }

    private class CustomViewSub extends RecyclerView.ViewHolder {
        View view;
        public CustomViewSub(View v) {
            super(v);
            view = v;
        }
    }
}
