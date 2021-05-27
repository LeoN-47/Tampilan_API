package com.leon.percobaan8;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.PostViewHolder> {

    List<Post_Detail> detail;
    Context contet;

    public DetailAdapter(Context context, List<Post_Detail> posts){
        this.contet = context;
        detail = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contet).inflate(R.layout.activity_detail, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return detail.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        TextView title, id, userId, body;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tampilan_title);
            id = itemView.findViewById(R.id.tampilan_id);
            body  = itemView.findViewById(R.id.tampilan_body);
        }
    }

}
