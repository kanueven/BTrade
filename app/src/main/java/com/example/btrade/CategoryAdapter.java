package com.example.btrade;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btrade.activities.DashboardActivity;

import java.util.ArrayList;
import java.util.Locale;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.catViewHolder> {
    ArrayList<CategModel>categloc;
    DashboardActivity activity;
    SharedPreferences prefs;

    public CategoryAdapter(DashboardActivity activity,ArrayList<CategModel> categloc) {
        this.categloc = categloc;
        this.activity = activity;
    }

    @NonNull
    @Override
    public catViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_design,parent,false);
        return new catViewHolder(view);
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

    public class catViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView title, desc;

        public catViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.categ_img);
            title = itemView.findViewById(R.id.categ_title);
            desc = itemView.findViewById(R.id.categ_desc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            prefs = activity.getSharedPreferences("BarterTrade", Context.MODE_PRIVATE) ;
            prefs.edit()
                    .putString("category", categloc.get(getBindingAdapterPosition()).title.toLowerCase(Locale.ROOT))
                    .apply();
            activity.loadProducts();
        }
    }}


