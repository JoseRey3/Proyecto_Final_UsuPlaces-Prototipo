package com.example.usuplace.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.usuplace.Domain.CategoryDomain;
import com.example.usuplace.R;
import com.example.usuplace.activites.ItemDetail;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    ArrayList<CategoryDomain>category;
    Context context;

    public CategoryAdapter(ArrayList<CategoryDomain> category){
        this.category = category;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.category.setText(category.get(position).getCategory());

        int drawablaResourceId = holder.imgCat.getResources().getIdentifier(category.get(position).getImgCat(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.imgCat.getContext())
                .load(drawablaResourceId)
                .into(holder.imgCat);

    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView category;
        ImageView imgCat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.category);
            imgCat = itemView.findViewById(R.id.imgCat);
        }
    }

}
