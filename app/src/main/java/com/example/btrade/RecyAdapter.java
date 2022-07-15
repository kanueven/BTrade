package com.example.btrade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ftViewHolder> {

    ArrayList<RecyModel> ftloc;
    public RecyAdapter(ArrayList<RecyModel> ftloc) {
        this.ftloc = ftloc;
    }

    @NonNull
    @Override
    public ftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyhome_activity,parent,false);
         ftViewHolder ftloc= new ftViewHolder(view);
        return ftloc;
    }

    @Override
    public void onBindViewHolder(@NonNull ftViewHolder holder, int position) {
        RecyModel recyModel= ftloc.get(position);
        holder.image.setImageResource(recyModel.getImage());
        holder.title.setText(recyModel.getTitle());
        holder.desc.setText(recyModel.getDescription());



    }

    @Override
    public int getItemCount() {
        return ftloc.size();
    }

    public static  class ftViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title,desc;

        public ftViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.ft_img);
            title=itemView.findViewById(R.id.ft_title);
            desc=itemView.findViewById(R.id.ft_desc);
        }
    }

}
