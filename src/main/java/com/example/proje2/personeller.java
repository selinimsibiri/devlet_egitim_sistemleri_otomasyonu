package com.example.proje2;

public class personeller extends calisanlar{
    String is;

    @Override
    public void ogretmenler(String isim, String soyisim, String tc, String brans) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.tc = tc;
        this.is = brans;
    }
}
