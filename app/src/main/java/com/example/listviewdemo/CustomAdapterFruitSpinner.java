package com.example.listviewdemo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterFruitSpinner extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Fruit> arrayListFruit;
    int layoutItem;

    public CustomAdapterFruitSpinner(Activity context, int layoutItem,ArrayList<Fruit> arrayListFruit) {
        this.layoutInflater = context.getLayoutInflater();
        this.arrayListFruit = arrayListFruit;
        this.layoutItem = layoutItem;
    }

    @Override
    public int getCount() {
        return this.arrayListFruit.size();
    }

    @Override
    public Object getItem(int position) {
        return this.arrayListFruit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Fruit fruit = arrayListFruit.get(position);
       View rowView = layoutInflater.inflate(layoutItem,null,true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgFruit);
        imageView.setImageResource(fruit.getIdImg());

        TextView tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvName.setText(fruit.getName());

        TextView tvPrice = (TextView) rowView.findViewById(R.id.tvPrice);
        tvPrice.setText(String.valueOf(fruit.getPrice()));

        return rowView;
    }
}
