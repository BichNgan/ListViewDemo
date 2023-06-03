package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Recy_Fruit extends AppCompatActivity {

    RecyclerView recyFruit;
    ArrayList<Fruit>arrayListFruit = new ArrayList<>();
    CustomAdapterRecycleFruit adapter;

    int[]lsHinhAnh = new int[]{R.drawable.apple, R.drawable.pineapple, R.drawable.mango,R.drawable.litchi,R.drawable.banana};
    String[]lsTen=new String[]{"Táo","Thơm","Xoài", "Dau","Chuối"};
    int[]lsGia=new int[]{100,20,50,80,15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_fruit);
        Intent intent=getIntent();

        recyFruit=(RecyclerView) findViewById(R.id.recyFruit);
        //---------------------------
        arrayListFruit=Fruit.iniArrayListFruit(lsHinhAnh,lsTen,lsGia);

        //recyFruit.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        adapter=new CustomAdapterRecycleFruit(arrayListFruit);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyFruit.setLayoutManager(layoutManager);
        //recyFruit.setItemAnimator(new DefaultItemAnimator());
        recyFruit.setAdapter(adapter);
    }
}