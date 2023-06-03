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

public class CustomAdapterFruit extends ArrayAdapter {
    Context context;
    int layoutItem;
    ArrayList<Fruit>arrayListFruit;

    public CustomAdapterFruit(@NonNull Context context, int layoutItem, @NonNull ArrayList<Fruit>arrayListFruit) {
        super(context, layoutItem, arrayListFruit);
        this.context=context;
        this.layoutItem=layoutItem;
        this.arrayListFruit=arrayListFruit;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit=arrayListFruit.get(position);
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(layoutItem,null);
        }
        ImageView imgFruit = (ImageView) convertView.findViewById(R.id.imgFruit);
        imgFruit.setImageResource(fruit.getIdImg());

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(fruit.getName());

        TextView tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
        tvPrice.setText(String.valueOf(fruit.getPrice()));

        return convertView;
    }
}
