package com.example.btrade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.tViewHolder> {
    ArrayList<TrendyModel>tloc;

    public TrendingAdapter(ArrayList<TrendyModel> tloc) {this.tloc = tloc;
    }

    @NonNull
    @Override
    public tViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_design,parent,false);
        TrendingAdapter.tViewHolder tloc= new TrendingAdapter.tViewHolder(view);
        return tloc;
    }

    @Override
    public void onBindViewHolder(@NonNull tViewHolder holder, int position) {
        TrendyModel trendyModel= tloc.get(position);
        holder.image.setImageResource(trendyModel.getImage());
        holder.title.setText(trendyModel.getTitle());
        holder.desc.setText(trendyModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return tloc.size();
    }

    public static  class tViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, desc;

        public tViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ms_img);
            title = itemView.findViewById(R.id.ms_title);
            desc = itemView.findViewById(R.id.ms_desc);
        }
    }}

