package com.example.listviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterRecycleFruit extends RecyclerView.Adapter<CustomAdapterRecycleFruit.MyViewHolder>{
    ArrayList<Fruit>arrayListFruit = new ArrayList<>();

    public CustomAdapterRecycleFruit(ArrayList<Fruit> arrayListFruit) {
        this.arrayListFruit = arrayListFruit;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_fruit,
                parent,false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Fruit fruit = arrayListFruit.get(position);
        holder.imgFruit.setImageResource(fruit.getIdImg());
        holder.tvName.setText(fruit.getName());
        holder.tvPrice.setText(String.valueOf(fruit.getPrice()));
    }
    @Override
    public int getItemCount() {
        return arrayListFruit.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFruit;
        TextView tvName;
        TextView tvPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFruit=(ImageView) itemView.findViewById(R.id.imgFruit);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPrice=(TextView) itemView.findViewById(R.id.tvPrice);

        }
    }
}
