/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.kooperatif.controller;

import com.mycompany.kooperatif.model.Gider;
import com.mycompany.kooperatif.repository.FinansRepository;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GiderEkleController implements Initializable {
    @FXML private TextField txtGiderAd;
    @FXML private TextField txtGiderMiktar;
    @FXML private TextField txtGiderTur;
    @FXML private TextField txtGiderTarih;
    @FXML private TextField txtDetay;
    
    @FXML private Button butonIptal;
    @FXML private Button butonKaydet;
    
    private FinansRepository finansRepo=new FinansRepository();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtGiderTarih.setText(LocalDate.now().toString());
    }     
    
    @FXML private void handleKaydet(ActionEvent event){
        try{
            Double miktar=Double.parseDouble(txtGiderMiktar.getText());
            String kaynak=txtGiderTur.getText();
            String tarih=txtGiderTarih.getText();
            String detay=txtDetay.getText();
            
            Gider gider=new Gider(miktar,tarih,kaynak,detay);
            finansRepo.giderEkle(gider);
            
            pencereyiKapat();
        }catch(NumberFormatException e){
            System.err.println("Miktar alanı sayı olmalıdır.");
        }catch(Exception e){
            System.err.println("Gelir eklenirken hata oluştu.");
        }
    }
    
    @FXML private void handleIptal(){
        pencereyiKapat();
    }
    
    private void pencereyiKapat(){
        Stage stage=(Stage) butonIptal.getScene().getWindow();
        stage.close();
    }
    
}
