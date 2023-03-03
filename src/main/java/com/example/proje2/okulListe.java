package com.example.proje2;

import java.util.ArrayList;

public class okulListe {
    private String isim;
    private String konum;
    private String mudur;
    private int notOrt,id;
    ArrayList<ogretmenler> ogretmenListe = new ArrayList<ogretmenler>();

    //constructor
    public okulListe(int id, String isim, String konum, String mudur, int notOrt) {
        this.id = id;
        this.isim = isim;
        this.konum = konum;
        this.mudur = mudur;
        this.notOrt = notOrt;
    }
    //Encapsulation
    public int getId(){
        return id;
    }
    public String getIsim(){
        return isim;
    }
    public String getKonum(){
        return konum;
    }
    public String getMudur(){
        return mudur;
    }
    public int getNotOrt(){
        return notOrt;
    }

}
