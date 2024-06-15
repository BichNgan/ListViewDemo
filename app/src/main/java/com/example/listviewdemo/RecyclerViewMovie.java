package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewMovie extends AppCompatActivity {

    RecyclerView recyMovie;
    ArrayList<Movie>arrayListMovie=new ArrayList<>();
    AdapterMovie adapterMovie;
    //----------------------------
    String[]lsMovieName=new String[]{"John Wick","Bố già","Avartar"};
    String[]lsGenner=new String[]{"Hành động","Mafia","KHVT"};
    String[]lsYear=new String[]{"2015","1997","2018"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_movie);
        recyMovie=(RecyclerView) findViewById(R.id.recyMovie);
        //-----------------------------------------------------
        arrayListMovie=Movie.iniArrayListMovie(lsMovieName,lsGenner,lsYear);
        //------------------------
        adapterMovie=new AdapterMovie(arrayListMovie);

        recyMovie.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

        RecyclerView.LayoutManager mLayoutManager=
                new LinearLayoutManager(RecyclerViewMovie.this);

        recyMovie.setLayoutManager(mLayoutManager);
        recyMovie.setItemAnimator(new DefaultItemAnimator());
        recyMovie.setAdapter(adapterMovie);
    }
}