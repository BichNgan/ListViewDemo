package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewDemo extends AppCompatActivity {

    RecyclerView recyCom;
    ArrayList<Company> arrayListCom=new ArrayList<>();
    CusAdapterReCyCom cusAdapterReCyCom;

    String[]lsName = new String[]{"Google", "FPT", "P&G"};
    String[]lsNation = new String[]{"USA", "VN", "France"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        setContentView(R.layout.activity_recycler_view_demo);
        recyCom=(RecyclerView) findViewById(R.id.recyCom);

        arrayListCom = Company.initArrayListCompany(lsName,lsNation);

        recyCom.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        cusAdapterReCyCom=new CusAdapterReCyCom(arrayListCom);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyCom.setLayoutManager(layoutManager);
        recyCom.setAdapter(cusAdapterReCyCom);
    }
}