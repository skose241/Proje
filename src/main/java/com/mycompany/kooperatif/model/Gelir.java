/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.model;

public class Gelir {
    private int id;
    private double miktar;
    private String tarih;
    private String kaynak;
    
    public Gelir(){
    }
    
    public Gelir(double miktar, String tarih, String kaynak){
        this.miktar=miktar;
        this.tarih=tarih;
        this.kaynak=kaynak;
    }
    
    public Gelir(int id, double miktar, String tarih, String kaynak){
        this.id=id;
        this.miktar=miktar;
        this.tarih=tarih;
        this.kaynak=kaynak;
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
    
    
    public String toString(){
        return kaynak+"= ("+miktar+" TL)";
    }
}
