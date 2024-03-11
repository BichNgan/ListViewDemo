package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerDemo extends AppCompatActivity {

    Spinner spinner_danhmuc, spinner_traicay;
    ArrayList<String> data=new ArrayList<>();

    ArrayList<Fruit>arrayListFruit=new ArrayList<>();
    CustomAdapterFruitSpinner adapterFruit;
    int[] lsIdImg = new int[]{R.drawable.apple,R.drawable.banana, R.drawable.litchi,
            R.drawable.mango,R.drawable.pineapple};
    String[]lsName= new String[]{"Táo","Chuối","Dâu","Xoài","Thơm"};
    int[]lsPrice = new int[]{100,12,80,20,30};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_demo);
        //----------------------------------------------
        spinner_danhmuc=(Spinner) findViewById(R.id.spinner_danhmuc);
        initData();
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,data);
        spinner_danhmuc.setAdapter(adapter);

        spinner_danhmuc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),data.get(position),Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //----------------------------------
        spinner_traicay=(Spinner)findViewById(R.id.spinner_traicay);
        arrayListFruit= Fruit.iniArrayListFruit(lsIdImg,lsName,lsPrice);
        adapterFruit=new CustomAdapterFruitSpinner(SpinnerDemo.this,R.layout.layout_item_fruit,arrayListFruit);
        spinner_traicay.setAdapter(adapterFruit);
    }
    private void initData()
    {
        data.add("James Smith - (Receptionist)");
        data.add("Window");
        data.add("IOs");
        data.add("Window Mobile");
    }
}