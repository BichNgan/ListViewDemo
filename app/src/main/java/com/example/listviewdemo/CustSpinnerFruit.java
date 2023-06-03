package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

public class CustSpinnerFruit extends AppCompatActivity {

    Spinner spCusFruit;
    ArrayList<Fruit>arrayListFruit=new ArrayList<>();
    CustomAdapterFruitSpinner adapter;

    int[] lsIdImg = new int[]{R.drawable.apple,R.drawable.banana, R.drawable.litchi,
            R.drawable.mango,R.drawable.pineapple};
    String[]lsName= new String[]{"Táo","Chuối","Dâu","Xoài","Thơm"};
    int[]lsPrice = new int[]{100,12,80,20,30};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_spinner_fruit);
        addControls();

        arrayListFruit=Fruit.iniArrayListFruit(lsIdImg,lsName,lsPrice);
        adapter=new CustomAdapterFruitSpinner(CustSpinnerFruit.this,R.layout.layout_item_fruit,arrayListFruit);
        spCusFruit.setAdapter(adapter);

    }

    private void addControls()
    {
        spCusFruit=(Spinner) findViewById(R.id.spCusFruit);
    }
}