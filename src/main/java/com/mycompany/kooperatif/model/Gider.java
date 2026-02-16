/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.model;

public class Gider {
    private int id;
    private double miktar;
    private String tarih;
    private String kaynak;
    private String detay;
    
    public Gider(){
    }
    
    public Gider(double miktar, String tarih, String kaynak, String detay){
        this.miktar=miktar;
        this.tarih=tarih;
        this.kaynak=kaynak;
        this.detay=detay;
    }
    
    public Gider(int id, double miktar, String tarih, String kaynak, String detay){
        this.id=id;
        this.miktar=miktar;
        this.tarih=tarih;
        this.kaynak=kaynak;
        this.detay=detay;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
    
    public String getKaynak() {
        return kaynak;
    }

    public void setKaynak(String kaynak) {
        this.kaynak = kaynak;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }
}
