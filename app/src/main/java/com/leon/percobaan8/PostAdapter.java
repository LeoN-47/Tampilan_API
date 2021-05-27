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

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    List<Post> postList;
    Context context;

    public PostAdapter(Context context, List<Post> posts){
        this.context = context;
                postList = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_movie_card, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        Post post = postList.get(position);

        String Id = post.getId();

        holder.id.setText(post.getId());
        holder.userId.setText(post.getUserId());
        holder.title.setText(post.getTitle());
        holder.body.setText(post.getBody());

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetail = new Intent(context, Detail.class);
                intentDetail.putExtra("Idlist",Id);
                context.startActivity(intentDetail);

            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        TextView title, id, userId, body;
        Button btnDetail;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tx_title);
            id = itemView.findViewById(R.id.tx_id);
            userId = itemView.findViewById(R.id.tx_userid);
            body  = itemView.findViewById(R.id.tx_body);
            btnDetail  = itemView.findViewById(R.id.btn_List_detail);

        }
    }

}
