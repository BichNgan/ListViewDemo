package com.example.listviewdemo;

import java.util.ArrayList;

public class Company {
    String name;
    String nation;

    public Company(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
    public static ArrayList<Company> initArrayListCompany(String[] lsName,String[]lsNation)
    {
        ArrayList<Company> arrayListCom=new ArrayList<>();
        for(int i=0;i<lsName.length; i++)
        {
            Company company=new Company(lsName[i],lsNation[i]);
            arrayListCom.add(company);
        }
        return arrayListCom;
    }

}
