
package com.example.videorecyclecustombasicadapter.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.videorecyclecustombasicadapter.model.Member;
import com.example.videorecyclecustombasicadapter.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Member> members;

    public CustomAdapter(Context context, ArrayList<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cutom_layout, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if (holder instanceof CustomViewHolder){
            TextView first_name = ((CustomViewHolder) holder).firstName;
            TextView last_name = ((CustomViewHolder) holder).lastName;

            first_name.setText(member.getFirstName());
            last_name.setText((member.getLastName()));
        }
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView firstName;
        TextView lastName;

        CustomViewHolder(View v){
            super(v);
            this.view = v;
            firstName = view.findViewById(R.id.first_name);
            lastName = view.findViewById(R.id.last_name);
        }
    }


    @Override
    public int getItemCount() {
        return members.size();
    }
}