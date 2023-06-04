package com.example.acsitp;

import android.content.Context;

import java.util.List;

public class Maladie_creation {
    private MaladieDAO maladieDAO;

    public String name;
    private  String des;
    private List<String> syps;
    public Maladie_creation(MaladieDAO maladieDAO){
        this.maladieDAO = maladieDAO;

    };


    public void create(String name,String des, String syps){
        Maladie maladie = new Maladie(name,des,syps);
        this.maladieDAO.addMaladie(maladie);
    }
    public void create(String name,String des){
        Maladie maladie = new Maladie(name,des);
        this.maladieDAO.addMaladie(maladie);
    }






}
