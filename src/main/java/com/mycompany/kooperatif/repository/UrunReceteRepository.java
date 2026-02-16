/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.repository;

import com.mycompany.kooperatif.model.UrunRecete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UrunReceteRepository {
    public boolean receteEkle(UrunRecete recete){
        String sql="INSERT INTO UrunRecete(urun_id,mal_id,miktar) VALUES(?,?,?)";
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            
            pstmt.setInt(1, recete.getUrunID());
            pstmt.setInt(2, recete.getMalID());
            pstmt.setInt(3, recete.getMiktar());
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Reçete ekleme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public List<UrunRecete> getReceteByUrunID(int urunID){
        String sql="SELECT * FROM UrunRecete WHERE urun_id=?";
        List<UrunRecete> receteListesi=new ArrayList<>();
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            
            pstmt.setInt(1, urunID);
            
            try(ResultSet rs=pstmt.executeQuery()){
                while(rs.next()){
                    int id=rs.getInt("id");
                    int uID=rs.getInt("urun_id");
                    int mID=rs.getInt("mal_id");
                    int miktar=rs.getInt("miktar");
                    
                    UrunRecete recete=new UrunRecete(id,uID,mID,miktar);
                    receteListesi.add(recete);
                }
            }
        }catch(SQLException e){
            System.err.println("Reçete listeleme hatası:"+e.getMessage());
            e.printStackTrace();
        }
        return receteListesi;
    }
    
}
