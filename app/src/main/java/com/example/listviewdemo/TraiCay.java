package com.example.listviewdemo;

import java.util.ArrayList;

public class TraiCay {
    int idHinhAnh;
    String tenTC;
    int giaTC;

    public int getIdHinhAnh() {
        return idHinhAnh;
    }

    public void setIdHinhAnh(int idHinhAnh) {
        this.idHinhAnh = idHinhAnh;
    }

    public String getTenTC() {
        return tenTC;
    }

    public void setTenTC(String tenTC) {
        this.tenTC = tenTC;
    }

    public int getGiaTC() {
        return giaTC;
    }

    public void setGiaTC(int giaTC) {
        this.giaTC = giaTC;
    }

    public TraiCay(int idHinhAnh, String tenTC, int giaTC) {
        this.idHinhAnh = idHinhAnh;
        this.tenTC = tenTC;
        this.giaTC = giaTC;
    }

    public static  ArrayList<TraiCay> initArrayListTraiCay(int[]lsHinhAnh, String[]lsTen, int[]lsGia)
    {
        ArrayList<TraiCay> arrayListTC = new ArrayList<>();
        for(int i=0; i<lsHinhAnh.length; i++)
        {
            TraiCay tc = new TraiCay(lsHinhAnh[i], lsTen[i], lsGia[i]);
            arrayListTC.add(tc);
        }
        return  arrayListTC;
    }

}
