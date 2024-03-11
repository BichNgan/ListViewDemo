package com.example.listviewdemo;

import java.util.ArrayList;

public class Movie {
    String name;
    String genner;
    String year;

    public Movie(String name, String genner, String year) {
        this.name = name;
        this.genner = genner;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenner() {
        return genner;
    }

    public void setGenner(String genner) {
        this.genner = genner;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public static ArrayList<Movie> iniArrayListMovie(String[] lsName,String[]lsGenner, String[] lsYear)
    {
        ArrayList<Movie> arrayListMoive = new ArrayList<>();
        for(int i=0; i<lsName.length; i++)
        {
            Movie movie = new Movie(lsName[i],lsGenner[i],lsYear[i]);
            arrayListMoive.add(movie);
        }
        return arrayListMoive;
    }
}
