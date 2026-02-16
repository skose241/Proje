/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.model;

public class UrunRecete {
    private int ID;
    private int urunID;
    private int malID;
    private int miktar;
    
    public UrunRecete(int urunID,int malID,int miktar){
        this.urunID=urunID;
        this.malID=malID;
        this.miktar=miktar;
    }
    
    public UrunRecete(int ID,int urunID,int malID,int miktar){
        this.ID=ID;
        this.urunID=urunID;
        this.malID=malID;
        this.miktar=miktar;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUrunID() {
        return urunID;
    }

    public void setUrunID(int urunID) {
        this.urunID = urunID;
    }

    public int getMalID() {
        return malID;
    }

    public void setMalID(int malID) {
        this.malID = malID;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }
    
}
