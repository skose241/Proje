/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.kooperatif.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;  

public class AnaMenuController implements Initializable {
    @FXML private Button butonStok;
    @FXML private Button butonFinans;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    @FXML private void handleStok(ActionEvent event){
        pencereAc("StokYonetimi.fxml", "Stok Yönetim Sistemi");
    }
    
    @FXML private void handleFinans(ActionEvent event){
        pencereAc("Finans.fxml", "Finans Yönetim Sistemi");
    }
    
    private void pencereAc(String fxmlDosyasi, String baslik){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource(fxmlDosyasi));
            Parent root=loader.load();
            
            Stage stage=new Stage();
            stage.setTitle(baslik);
            stage.setScene(new Scene(root));
            stage.showAndWait();
            
        }catch(IOException e){
            System.err.println(fxmlDosyasi+" açılırken hata oluştu.");
            e.printStackTrace();
        }
    }
}
