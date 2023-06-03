package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SpinnerCompany extends AppCompatActivity {
    Spinner spinnerCom;
    String[] lsCom=new String[]{"FPT","Tesla","Meta"};
    ArrayAdapter<String> adapter;
    //--------------------------
    Spinner spinnerTC;
    ArrayList<Fruit>arrayListFruit=new ArrayList<>();
    CustomAdapterFruitSpinner adapSpinnerTC;

    int[] lsIdImg = new int[]{R.drawable.apple,R.drawable.banana, R.drawable.litchi,
            R.drawable.mango,R.drawable.pineapple};
    String[]lsName= new String[]{"Táo","Chuối","Dâu","Xoài","Thơm"};
    int[]lsPrice = new int[]{100,12,80,20,30};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_company);
        Intent intent=getIntent();
        spinnerCom=(Spinner) findViewById(R.id.spinnerCom);
        spinnerTC=(Spinner) findViewById(R.id.spinnerTC);

        //--------------------------------------Spinner COmpany----------------------
        adapter=new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,lsCom);
        spinnerCom.setAdapter(adapter);

        spinnerCom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),lsCom[position],Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //--------------------------------------------------------------------
        //=======================CUSTOM SPINNER FRUIT ================================
        arrayListFruit=Fruit.iniArrayListFruit(lsIdImg,lsName,lsPrice);
        adapSpinnerTC=new CustomAdapterFruitSpinner(SpinnerCompany.this,R.layout.layout_item_fruit,arrayListFruit);
        spinnerTC.setAdapter(adapSpinnerTC);

        spinnerTC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerCompany.this,
                        "Trái cây được chọn là " + arrayListFruit.get(position).getName(),Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}