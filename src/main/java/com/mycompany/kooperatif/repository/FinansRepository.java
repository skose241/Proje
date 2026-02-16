/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.repository;

import com.mycompany.kooperatif.model.Gelir;
import com.mycompany.kooperatif.model.Gider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FinansRepository {
    public boolean gelirEkle(Gelir gelir){
        String sql="INSERT INTO Gelir(miktar,tarih,kaynak) VALUES(?,?,?,)";
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            
            pstmt.setDouble(1, gelir.getMiktar());
            pstmt.setString(2, gelir.getTarih());
            pstmt.setString(3, gelir.getKaynak());
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Gelir ekleme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Gelir> gelirListele(){
        String sql="SELECT * FROM Gelir";
        List<Gelir> gelirler=new ArrayList<>();
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                int id=rs.getInt("id");
                double miktar=rs.getDouble("miktar");
                String tarih=rs.getString("tarih");
                String kaynak=rs.getString("kaynak");
                
                Gelir gelir=new Gelir(id,miktar,tarih,kaynak);
                gelirler.add(gelir);
            }
        }catch(SQLException e){
            System.err.println("Gelir okuma hatası:"+e.getMessage());
            e.printStackTrace();
        }
        return gelirler;
    }
    
    public boolean gelirSil(int id){
        String sql="DELETE FROM Gelir Where id=?";
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Gelir silme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean giderEkle(Gider gider){
        String sql="INSERT INTO Gider(miktar,tarih,kaynak,detay)";
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            
            pstmt.setDouble(1, gider.getMiktar());
            pstmt.setString(2, gider.getTarih());
            pstmt.setString(3, gider.getKaynak());
            pstmt.setString(4, gider.getDetay());
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Gider ekleme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Gider> giderListele(){
        String sql="SELECT * FROM Gider";
        List<Gider> giderler=new ArrayList<>();
        
        try(Connection conn=VeritabaniBaglanti.baglan();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql)){
            while(rs.next()){
                int id=rs.getInt("id");
                double miktar=rs.getDouble("miktar");
                String tarih=rs.getString("tarih");
                String kaynak=rs.getString("kaynak");
                String detay=rs.getString("detay");
                
                Gider gider=new Gider(id,miktar,tarih,kaynak,detay);
                giderler.add(gider);
            }
        }catch(SQLException e){
            System.err.println("Gider okuma hatası:"+e.getMessage());
            e.printStackTrace();
        }
        return giderler;
    }
    
    public boolean giderSil(int id){
        String sql="DELETE FROM Gider Where id=?";
        try(Connection conn=VeritabaniBaglanti.baglan();
            PreparedStatement pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            
            pstmt.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println("Gider silme hatası:"+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
}
