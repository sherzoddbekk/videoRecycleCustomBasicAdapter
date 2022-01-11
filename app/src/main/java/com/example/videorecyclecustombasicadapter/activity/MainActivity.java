package com.example.videorecyclecustombasicadapter.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.videorecyclecustombasicadapter.R;
import com.example.videorecyclecustombasicadapter.adapter.CustomAdapter;
import com.example.videorecyclecustombasicadapter.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private Context context;
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        ArrayList<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void refreshAdapter(ArrayList<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);
    }

    private  void initView(){
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }


    private ArrayList<Member> prepareMemberList(){
        ArrayList<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            members.add(new Member(i+")Sherzod", i+")Jo'rabekov"));
        }
        return members;
    }


}