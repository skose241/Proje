/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.kooperatif.controller;

import com.mycompany.kooperatif.model.Gelir;
import com.mycompany.kooperatif.model.Gider;
import com.mycompany.kooperatif.repository.FinansRepository;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.Modality;
import java.io.IOException;

public class FinansController implements Initializable {
    private FinansRepository finansRepo=new FinansRepository();
    
    //Gelir
    @FXML private TableView<Gelir> gelirTablosu;
    
    @FXML private Button butonGelirEkle;
    @FXML private Button butonGelirSil;
    
    @FXML private TableColumn<Gelir, Integer> colGelirID;
    @FXML private TableColumn<Gelir, Double> colGelirMiktar;
    @FXML private TableColumn<Gelir, String> colGelirTarih;
    @FXML private TableColumn<Gelir, String> colGelirTur;
    
    
    //Gider
    @FXML private TableView<Gider> giderTablosu;
    
    @FXML private Button butonGiderEkle;
    @FXML private Button butonGiderSil;
    
    @FXML private TableColumn<Gider, Integer> colGiderID;
    @FXML private TableColumn<Gider, Double> colGiderMiktar;
    @FXML private TableColumn<Gider, String> colGiderTarih;
    @FXML private TableColumn<Gider, String> colGiderTur;
    @FXML private TableColumn<Gider, String> colDetay;
    
    private ObservableList<Gelir> gelirListesi=FXCollections.observableArrayList();
    private ObservableList<Gider> giderListesi=FXCollections.observableArrayList();
    
    
    
    public void tabloGelirDoldur(){
        List<Gelir> veriTabaniGelirleri=finansRepo.gelirListele();
        
        gelirListesi.clear();
        gelirListesi.addAll(veriTabaniGelirleri);
        
        gelirTablosu.setItems(gelirListesi);
    }
    
    
    @FXML void handleGelirEkle(ActionEvent event){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("GelirEkle.fxml"));
            Parent root=loader.load();
            
            Stage stage=new Stage();
            stage.setTitle("Yeni gelir ekle");
            stage.setScene(new Scene(root));
            
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(butonGelirEkle.getScene().getWindow());
            stage.showAndWait();
            
            tabloGelirDoldur();
        }catch(IOException e){
            System.err.println("GelirEkle.fxml dosyası yüklenirken hata oluştu.");
            e.printStackTrace();
        }
    }
    
    @FXML void handleGelirSil(ActionEvent event){
        Gelir seciliGelir=gelirTablosu.getSelectionModel().getSelectedItem();
        
        if(seciliGelir!=null){
            finansRepo.gelirSil(seciliGelir.getId());
            tabloGelirDoldur();
        }else{
            System.out.println("Silmek için lütfen satır seçin.");
        }
    }
    
    
    public void tabloGiderDoldur(){
        List<Gider> veriTabaniGiderleri=finansRepo.giderListele();
        
        giderListesi.clear();
        giderListesi.addAll(veriTabaniGiderleri);
        
        giderTablosu.setItems(giderListesi);
    }
    
    @FXML void handleGiderEkle(ActionEvent event){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("GiderEkle.fxml"));
            Parent root=loader.load();
            
            Stage stage=new Stage();
            stage.setTitle("Yeni gider ekle");
            stage.setScene(new Scene(root));
            
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(butonGiderEkle.getScene().getWindow());
            stage.showAndWait();
            
            tabloGiderDoldur();
        }catch(IOException e){
            System.err.println("GiderEkle.fxml dosyası yüklenirken hata oluştu.");
            e.printStackTrace();
        }
    }
    
    @FXML void handleGiderSil(ActionEvent event){
        Gider seciliGider=giderTablosu.getSelectionModel().getSelectedItem();
        
        if(seciliGider!=null){
            finansRepo.giderSil(seciliGider.getId());
            tabloGiderDoldur();
        }else{
            System.out.println("Silmek için lütfen satır seçin.");
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Finans Controller başlatıldı.");
        
        colGelirID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colGelirMiktar.setCellValueFactory(new PropertyValueFactory<>("miktar"));
        colGelirTarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
        colGelirTur.setCellValueFactory(new PropertyValueFactory<>("kaynak"));
        
        colGiderID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colGiderMiktar.setCellValueFactory(new PropertyValueFactory<>("miktar"));
        colGiderTarih.setCellValueFactory(new PropertyValueFactory<>("tarih"));
        colGiderTur.setCellValueFactory(new PropertyValueFactory<>("Kaynak"));
        colDetay.setCellValueFactory(new PropertyValueFactory<>("detay"));
        
        tabloGelirDoldur();
        tabloGiderDoldur();
    }    
    
}
