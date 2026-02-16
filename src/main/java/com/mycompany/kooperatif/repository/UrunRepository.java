/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.repository;

import com.mycompany.kooperatif.model.Urun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
public class UrunRepository {
    public boolean UrunEkle(Urun urun){
        String sql="INSERT INTO Urun(ad,fiyat,stok) VALUES(?,?,?)";
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            
            pstmt.setString(1, urun.getAd());
            pstmt.setDouble(2, urun.getFiyat());
            pstmt.setInt(3, urun.getStok());
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Ürün ekleme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Urun> urunListele(){
        String sql="SELECT * FROM Urun";
        List<Urun> urunler=new ArrayList<>();
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                int id=rs.getInt("id");
                String ad=rs.getString("ad");
                double fiyat=rs.getDouble("fiyat");
                int stok=rs.getInt("stok");
                
                Urun urun=new Urun(id,ad,fiyat,stok);
                urunler.add(urun);
            } 
        }catch(SQLException e){
            System.err.println("Ürün okuma hatası:"+e.getMessage());
            e.printStackTrace();
        }
        return urunler;
    }
    
    public boolean urunGuncelle(Urun urun){
        String sql="UPDATE Urun SET ad=?,fiyat=?,stok=? WHERE id=?";
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1, urun.getAd());
            pstmt.setDouble(2, urun.getFiyat());
            pstmt.setInt(3, urun.getStok());
            pstmt.setInt(4, urun.getId());
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Ürün güncelleme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean urunSil(int id){
        String sql="DELETE FROM Urun WHERE id=?";
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Ürün silme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public Urun getUrunByID(int id){
        String sql="SELECT * FROM Urun WHERE id=?";
        Urun urun=null;
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            
            if(rs.next()){
                urun=new Urun(
                rs.getInt("id"),
                rs.getString("ad"),
                rs.getDouble("fiyat"),
                rs.getInt("stok")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return urun;
    }
   
}
