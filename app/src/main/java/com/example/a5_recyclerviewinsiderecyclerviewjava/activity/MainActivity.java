package com.example.a5_recyclerviewinsiderecyclerviewjava.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a5_recyclerviewinsiderecyclerviewjava.R;
import com.example.a5_recyclerviewinsiderecyclerviewjava.adapter.CustomAdapter;
import com.example.a5_recyclerviewinsiderecyclerviewjava.model.Member;
import com.example.a5_recyclerviewinsiderecyclerviewjava.model.MemberSub;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    void initViews(){
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager
                (context, 1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < 40; i++){
            if (i == 2 || i == 10 || i == 15 || i == 26 || i == 36){
                members.add(new Member("Odilbek", "+998 97 775 17 79", prepareSubMemberList()));
            }else {
                members.add(new Member("Odilbek", "+998 97 775 17 79", null));
            }
        }
        return members;
    }

    private List<MemberSub> prepareSubMemberList() {
        List<MemberSub> memberSubs = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            memberSubs.add(new MemberSub());
        }
        return memberSubs;
    }
}