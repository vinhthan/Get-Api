package com.example.part1simplegetrequestll3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    List<Post> list;
    Context context;

    public PostAdapter(List<Post> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = list.get(position);

        //kiểu int mà setText thì phải có String.valueOf()
        holder.txvUserId.setText(String.valueOf(post.getUserId()));
        holder.txvId.setText(String.valueOf(post.getId()));
        holder.txvTitle.setText(post.getTitle());
        holder.txvBody.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txvUserId, txvId, txvTitle, txvBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txvUserId = itemView.findViewById(R.id.txvUserId);
            txvId = itemView.findViewById(R.id.txvId);
            txvTitle = itemView.findViewById(R.id.txvTitle);
            txvBody = itemView.findViewById(R.id.txvBody);
        }
    }
}
