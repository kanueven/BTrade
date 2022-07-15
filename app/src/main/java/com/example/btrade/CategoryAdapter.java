package com.example.btrade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.catViewHolder> {
    ArrayList<CategModel>categloc;

    public CategoryAdapter(ArrayList<CategModel> categloc) {
        this.categloc = categloc;

    }

    @NonNull
    @Override
    public catViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_design,parent,false);
        CategoryAdapter.catViewHolder categloc= new CategoryAdapter.catViewHolder(view);
        return categloc;
    }

    @Override
    public void onBindViewHolder(@NonNull catViewHolder holder, int position) {
        CategModel categModel= categloc.get(position);
        holder.image.setImageResource(categModel.getImage());
        holder.title.setText(categModel.getTitle());
        holder.desc.setText(categModel.getDescription());
    }

    @Override
    public int getItemCount() {
        return categloc.size();
    }

    public static  class catViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, desc;

        public catViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.categ_img);
            title = itemView.findViewById(R.id.categ_title);
            desc = itemView.findViewById(R.id.categ_desc);
        }
}}


