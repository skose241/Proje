/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.kooperatif.controller;

import com.mycompany.kooperatif.model.Malzeme;
import com.mycompany.kooperatif.repository.MalzemeRepository;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MalzemeEkleController implements Initializable {

    @FXML private TextField txtAd;
    @FXML private TextField txtMiktar;
    @FXML private TextField txtTur;
    
    @FXML private Button butonKaydet;
    @FXML private Button butonIptal;
    
    private MalzemeRepository malRepo=new MalzemeRepository();
    
    private Malzeme guncellenecekMal;
    
    @FXML private void handleKaydet(ActionEvent event){
        
        try{
            String ad=txtAd.getText();
            int miktar=Integer.parseInt(txtMiktar.getText());
            String tur=txtTur.getText();
            
            if(ad.isEmpty() || tur.isEmpty()){
                System.out.println("Ad veya tür boş olamaz.");
                return;
            }
            
            if(guncellenecekMal==null){
                System.out.println("Yeni kayıt modu:Ekleme yapılıyor..");
                Malzeme yeniMal=new Malzeme(ad,miktar,tur);
                malRepo.MalEkle(yeniMal);
            }else{
                System.out.println("Güncelleme modu:Kayıt güncelleniyor..");
                guncellenecekMal.setAd(ad);
                guncellenecekMal.setMiktar(miktar);
                guncellenecekMal.setTur(tur);
                
                malRepo.malGuncelle(guncellenecekMal);
            }
            
            pencereyiKapat();
        }catch(NumberFormatException e){
            System.err.println("Miktar alanı sayı olmalıdır.");
        }catch(Exception e){
            System.err.println("Malzeme eklenirken hata oluştu.");
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
    
    public void veriyiYukle(Malzeme mal){
        this.guncellenecekMal=mal;
        txtAd.setText(mal.getAd());
        txtMiktar.setText(String.valueOf(mal.getMiktar()));
        txtTur.setText(mal.getTur());
    }
}
