package com.example.listviewdemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CusAdapSpin extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<Fruit>arrayListFruit;
    int layoutItem;
    //context là activity chứa cả spinner; layoutInflater là nối layoutItem với từng item con
    public CusAdapSpin(Activity context, ArrayList<Fruit> arrayListFruit, int layoutItem) {
        this.layoutInflater = context.getLayoutInflater();
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
        return null;
    }
}
