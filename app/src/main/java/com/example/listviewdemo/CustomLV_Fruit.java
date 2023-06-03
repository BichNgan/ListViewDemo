package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomLV_Fruit extends AppCompatActivity {

    ListView lvFruit;
    ArrayList<Fruit>arrayListFruit=new ArrayList<>();
    CustomAdapterFruit adapterFruit;
    int[] lsIdImg = new int[]{R.drawable.apple,R.drawable.banana, R.drawable.litchi,
            R.drawable.mango,R.drawable.pineapple};
    String[]lsName= new String[]{"Táo","Chuối","Dâu","Xoài","Thơm"};
    int[]lsPrice = new int[]{100,12,80,20,30};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_lv_fruit);
        Intent intent=getIntent();
        addControls();
        //Tạo dữ liệu ban đầu cho arrayListFruit
        arrayListFruit= Fruit.iniArrayListFruit(lsIdImg,lsName,lsPrice);
        adapterFruit=new CustomAdapterFruit(CustomLV_Fruit.this,
                R.layout.layout_item_fruit,arrayListFruit);
        lvFruit.setAdapter(adapterFruit);
    }
    private void addControls()
    {
        lvFruit=(ListView) findViewById(R.id.lvFruit);
    }
    private void addEvents()
    {

    }
}