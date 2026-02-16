/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.model;

public class Malzeme {
    private int id; 
    private String ad;
    private int miktar;
    private String tur;
    
    public Malzeme(String ad, int miktar, String tur){
        this.ad=ad;
        this.miktar=miktar;
        this.tur=tur;
    }
    
    public Malzeme(int id, String ad, int miktar, String tur){
        this.id=id;
        this.ad=ad;
        this.miktar=miktar;
        this.tur=tur;
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

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }
    
    
    public String toString(){
        return "Malzeme:"+"\n -id="+id+"\n -ad="+ad+"\n -miktar="+miktar+"\n -tür="+tur;
    }
}
