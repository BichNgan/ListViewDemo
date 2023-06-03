package com.example.listviewdemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CusAdapSpinnerTC extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<Fruit>arrayListFruit;
    int layoutItem;

    public CusAdapSpinnerTC(Activity context, ArrayList<Fruit> arrayListFruit, int layoutItem) {
        this.inflater = context.getLayoutInflater();
        this.arrayListFruit = arrayListFruit;
        this.layoutItem = layoutItem;
    }

    @Override
    public int getCount() {
        return arrayListFruit.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListFruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Fruit fruit=arrayListFruit.get(position);
       View rowView = inflater.inflate(layoutItem,null,true);

        ImageView imgFruit = (ImageView) rowView.findViewById(R.id.imgFruit);
        imgFruit.setImageResource(fruit.getIdImg());

        TextView tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvName.setText(fruit.getName());

        TextView tvPrice = (TextView) rowView.findViewById(R.id.tvPrice);
        tvName.setText(String.valueOf(fruit.getPrice()));

        return rowView;
    }
}
