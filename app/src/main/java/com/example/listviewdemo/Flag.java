package com.example.listviewdemo;

public class Flag {
    int idAnh; //id ảnh lá cờ
    String tenQG;

    public int getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(int idAnh) {
        this.idAnh = idAnh;
    }

    public String getTenQG() {
        return tenQG;
    }

    public void setTenQG(String tenQG) {
        this.tenQG = tenQG;
    }

    public Flag() {
    }

    public Flag(int idAnh, String tenQG) {
        this.idAnh = idAnh;
        this.tenQG = tenQG;
    }
}
