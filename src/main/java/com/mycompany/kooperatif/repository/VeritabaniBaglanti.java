/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class VeritabaniBaglanti {
    private static final String DB_URL = "jdbc:sqlite:kooperatif.db";
    
    public static Connection baglan(){
        try{
            return DriverManager.getConnection(DB_URL); 
        }catch(SQLException e){
            System.err.println("Veri tabanı bağlantı hatası:"+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public static void veritabaniOlustur(){
        String sqlMalzemeTablosu="CREATE TABLE IF NOT EXISTS Malzeme("
                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"   
                +"ad TEXT NOT NULL,"                       
                +"miktar INTEGER DEFAULT 0,"                
                +"tur TEXT"                                 
                +");";
        
        String sqlUrunTablosu="CREATE TABLE IF NOT EXISTS Urun("
                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"ad TEXT NOT NULL,"
                +"fiyat REAL DEFAULT 0,"
                +"stok INTEGER DEFAULT 0"
                +");";
        
        String sqlReceteTablosu="CREATE TABLE IF NOT EXISTS UrunRecete("
                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"urun_id INTEGER NOT NULL,"
                +"mal_id INTEGER NOT NULL,"
                +"miktar INTEGER DEFAULT 0,"
                +"FOREIGN KEY(urun_id) REFERENCES Urun(id),"
                +"FOREIGN KEY(mal_id) REFERENCES Malzeme(id)"
                +");";
        
        String sqlGelirTablosu="CREATE TABLE IF NOT EXISTS Gelir("
                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"miktar INTEGER DEFAULT 0,"
                +"tarih TEXT NOT NULL,"
                +"kaynak TEXT NOT NULL"
                +");";
        
        String sqlGiderTablosu="CREATE TABLE IF NOT EXISTS Gider("
                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"miktar INTEGER DEFAULT 0,"
                +"tarih TEXT NOT NULL,"
                +"kaynak TEXT NOT NULL,"
                +"detay TEXT NOT NULL"
                +");";
        try(Connection conn=baglan();
            Statement stmt=conn.createStatement()){
            stmt.execute(sqlMalzemeTablosu);
            stmt.execute(sqlUrunTablosu);
            stmt.execute(sqlReceteTablosu);
            stmt.execute(sqlGelirTablosu);
            stmt.execute(sqlGiderTablosu);
        }catch(SQLException e){
            System.err.println("Tablo oluşturma hatası:"+e.getMessage());
            e.printStackTrace();
        }catch(NullPointerException e){
            System.err.print("conn, null geldi. baglan() metodunu kontrol ediniz.");
            e.printStackTrace();
        }
    
        
    }
    
}

