package com.example.listviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CusAdapterReCyCom extends RecyclerView.Adapter<CusAdapterReCyCom.MyViewHolder> {

    ArrayList<Company> arrayListCom=new ArrayList<>();

    public CusAdapterReCyCom(ArrayList<Company> arrayListCom) {
        this.arrayListCom = arrayListCom;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_recy_com,
                parent,false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Company company=arrayListCom.get(position);
        holder.tvNameCom.setText(company.getName());
        holder.tvNation.setText(company.getNation());
    }

    @Override
    public int getItemCount() {
        return arrayListCom.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvNameCom, tvNation;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCom=(TextView)itemView.findViewById(R.id.tvNameCom);
            tvNation=(TextView) itemView.findViewById(R.id.tvNation)   ;
        }
    }
}
