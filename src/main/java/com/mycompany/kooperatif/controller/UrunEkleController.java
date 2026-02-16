/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.kooperatif.controller;

import com.mycompany.kooperatif.model.Urun;
import com.mycompany.kooperatif.repository.UrunRepository;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UrunEkleController implements Initializable {
    @FXML private TextField txtUrunAd;
    @FXML private TextField txtFiyat;
    @FXML private TextField txtStok;
    
    @FXML private Button butonKaydet;
    @FXML private Button butonIptal;
    
    private UrunRepository urunRepo=new UrunRepository();
    
    private Urun guncellenecekUrun;
    
    @FXML private void handleKaydet(ActionEvent event){
        try{
            String ad=txtUrunAd.getText();
            double fiyat=Double.parseDouble(txtFiyat.getText());
            int stok=Integer.parseInt(txtStok.getText());
            
            if(ad.isEmpty()){
                System.out.println("Ad boş olamaz.");
                return;
            }
            
            if(guncellenecekUrun==null){
                System.out.println("Yeni kayıt modu:Ekleme yapılıyor..");
                Urun yeniUrun=new Urun(ad,fiyat,stok);
                urunRepo.UrunEkle(yeniUrun);
            }else{
                System.out.println("Güncelleme modu:Kayıt güncelleniyor..");
                guncellenecekUrun.setAd(ad);
                guncellenecekUrun.setFiyat(fiyat);
                guncellenecekUrun.setStok(stok);
                
                urunRepo.urunGuncelle(guncellenecekUrun);
            }
            pencereyiKapat();
        }catch(NumberFormatException e){
            System.err.println("Stok alanı sayı olmalıdır.");
        }catch(Exception e){
            System.err.println("Ürün eklenirken hata oluştu.");
            e.printStackTrace();
        }
    }
    
    @FXML private void handleIptal(){
        pencereyiKapat();
    }
    
    private void pencereyiKapat(){
        Stage stage=(Stage) butonIptal.getScene().getWindow();
        stage.close();
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void veriyiYukle(Urun urun){
        this.guncellenecekUrun=urun;
        txtUrunAd.setText(urun.getAd());
        txtFiyat.setText(String.valueOf(urun.getFiyat()));
        txtStok.setText(String.valueOf(urun.getStok()));
    }
}
