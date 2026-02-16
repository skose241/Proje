/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.model;

public class Urun {
    private int id;
    private String ad;
    private double fiyat;
    private int stok;
    
    public Urun(String ad, double fiyat, int stok){
        this.ad=ad;
        this.fiyat=fiyat;
        this.stok=stok;
    }
    
    public Urun(int id, String ad, double fiyat, int stok){
        this.id=id;
        this.ad=ad;
        this.fiyat=fiyat;
        this.stok=stok;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    
    public String toString(){
        return "Ürün:"+"\n -id="+id+"\n -ad="+ad+"\n fiyat="+fiyat+"\n stok="+stok;
    }
}
