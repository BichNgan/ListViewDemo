package com.example.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapterTC extends ArrayAdapter {
    Context context;
    int layoutItem;
    ArrayList<TraiCay>arrayListTC=new ArrayList<>();


    public CustomAdapterTC(@NonNull Context context, int layoutItem, @NonNull ArrayList<TraiCay>arrayListTC) {
        super(context, layoutItem, arrayListTC);
        this.context=context;
        this.layoutItem=layoutItem;
        this.arrayListTC=arrayListTC;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TraiCay tc=arrayListTC.get(position);
        if(convertView==null)
            convertView= LayoutInflater.from(context).inflate(layoutItem,null);
        //Gắn id và dữ liệu cho các controls trên layout của item
        ImageView imgTC = (ImageView) convertView.findViewById(R.id.imgTC);
        imgTC.setImageResource(tc.getIdHinhAnh());

        TextView tvTen = (TextView) convertView.findViewById(R.id.tvTenTC);
        tvTen.setText(tc.getTenTC());

        TextView tvGia = (TextView)convertView.findViewById(R.id.tvGiaTC);
        tvGia.setText(String.valueOf(tc.getGiaTC()));
        return convertView;
    }
}
