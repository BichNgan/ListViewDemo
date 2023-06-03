package com.example.listviewdemo;

import java.util.ArrayList;

public class Fruit {
    int idImg;
    String name;
    int price;

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Fruit(int idImg, String name, int price) {
        this.idImg = idImg;
        this.name = name;
        this.price = price;
    }
    //Hàm khởi tạo danh sách fruit làm dữ liệu đưa lên Custom LV
    public static ArrayList<Fruit> iniArrayListFruit(int[]lsIdImg,String[] lsName, int[] lsPrice)
    {
        ArrayList<Fruit> arrayListFruit = new ArrayList<>();
        for(int i=0; i<lsIdImg.length; i++)
        {
            Fruit fruit=new Fruit(lsIdImg[i],lsName[i],lsPrice[i]);
            arrayListFruit.add(fruit);
        }
        return arrayListFruit;
    }

}
