package com.example.a5_recyclerviewinsiderecyclerviewjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a5_recyclerviewinsiderecyclerviewjava.R;
import com.example.a5_recyclerviewinsiderecyclerviewjava.model.Member;
import com.example.a5_recyclerviewinsiderecyclerviewjava.model.MemberSub;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_TYPE_VIEW = 0;
    private static final int ITEM_TYPE_LIST = 1;

    private Context context;
    private List<Member> members;

    public CustomAdapter(Context context, List<Member> members){
        this.context = context;
        this.members = members;
    }

    @Override
    public int getItemViewType(int position) {
        Member member = members.get(position);
        if (member.getMemberSubs() != null){
            return ITEM_TYPE_LIST;
        }
        return ITEM_TYPE_VIEW;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == ITEM_TYPE_LIST) {
            View list = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout_list, viewGroup, false);
            return new CustomList(list);
        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout_view, viewGroup, false);
        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        if (holder instanceof CustomView){

        }
        if (holder instanceof CustomList) {
            RecyclerView recyclerView = ((CustomList) holder).recyclerList;
            recyclerView.setLayoutManager(new GridLayoutManager(context, 1));

            List<MemberSub> memberSubs = member.getMemberSubs();
            refreshSubAdapter(recyclerView, memberSubs);
        }
    }
    private void refreshSubAdapter(RecyclerView recyclerView,List<MemberSub> memberSubs){
        CustomSubAdapter adapter = new CustomSubAdapter(context,  memberSubs);
        recyclerView.setAdapter(adapter);
    }

    private class CustomView extends RecyclerView.ViewHolder {

        public CustomView(View view) {
            super(view);
        }
    }

    private class CustomList extends RecyclerView.ViewHolder {
        public RecyclerView recyclerList;
        View view;
        public CustomList(View v) {
            super(v);
            view = v;
            recyclerList = view.findViewById(R.id.recyclerList);
        }
    }
}
