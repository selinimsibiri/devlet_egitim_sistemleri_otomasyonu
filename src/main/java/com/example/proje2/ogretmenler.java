package com.example.proje2;

import java.util.ArrayList;

public class ogretmenler extends calisanlar{
    String brans;

    public ogretmenler(String isim, String soyisim, String tc, String brans) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.tc = tc;
        this.brans = brans;
    }

    public String getIsim(){
        return isim;
    }
    public String getSoyisim(){
        return soyisim;
    }
    public String getTc(){
        return tc;
    }
    public String getBrans(){
        return brans;
    }

    @Override
    public void ogretmenler(String isim, String soyisim, String tc, String brans) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.tc = tc;
        this.brans = brans;
    }
}
