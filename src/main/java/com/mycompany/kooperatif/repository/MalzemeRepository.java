/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.repository;

import com.mycompany.kooperatif.model.Malzeme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
public class MalzemeRepository {
    public boolean MalEkle(Malzeme mal){
        String sql="INSERT INTO Malzeme(ad,miktar,tur) VALUES(?,?,?)";
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            
            pstmt.setString(1, mal.getAd());
            pstmt.setInt(2, mal.getMiktar());
            pstmt.setString(3, mal.getTur());
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Malzeme ekleme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Malzeme> malListele(){
        String sql="SELECT * FROM Malzeme";
        List<Malzeme> mallar=new ArrayList<>();
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                int id=rs.getInt("id");
                String ad=rs.getString("ad");
                int miktar=rs.getInt("miktar");
                String tur=rs.getString("tur");
                
                Malzeme mal=new Malzeme(id,ad,miktar,tur);
                mallar.add(mal);
            }
        }catch(SQLException e){
            System.err.println("Malzeme okuma hatası:"+e.getMessage());
            e.printStackTrace();
        }
        return mallar;  
    }
    
    public boolean malGuncelle(Malzeme mal){
        String sql="UPDATE Malzeme SET ad=?,miktar=?,tur=? WHERE id=?";
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setString(1, mal.getAd());
            pstmt.setInt(2, mal.getMiktar());
            pstmt.setString(3, mal.getTur());
            pstmt.setInt(4, mal.getId());
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Malzeme güncelleme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean malSil(int id){
        String sql="DELETE FROM Malzeme Where id=?";
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Mal silme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public Malzeme getMalzemeByID(int id){
        String sql="SELECT * FROM Malzeme WHERE id=?";
        Malzeme mal=null;
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            
            if(rs.next()){
                mal=new Malzeme(
                rs.getInt("id"),
                rs.getString("ad"),
                rs.getInt("miktar"),
                rs.getString("tur")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return mal;
    }
}
