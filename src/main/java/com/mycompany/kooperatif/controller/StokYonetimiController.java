/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.kooperatif.controller;

import com.mycompany.kooperatif.model.Malzeme;
import com.mycompany.kooperatif.repository.MalzemeRepository;
import com.mycompany.kooperatif.model.Urun;
import com.mycompany.kooperatif.repository.UrunRepository;

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


public class StokYonetimiController implements Initializable {
    private MalzemeRepository malRepo=new MalzemeRepository();
    private UrunRepository urunRepo=new UrunRepository();

    //Malzeme
    @FXML private TableView<Malzeme> malzemeTablosu;
    
    @FXML private Button butonMalEkle;
    @FXML private Button butonMalDegistir;
    @FXML private Button butonMalSil;
    
    @FXML private TableColumn<Malzeme, Integer> colMalID;
    @FXML private TableColumn<Malzeme, String> colMalAd;
    @FXML private TableColumn<Malzeme, Integer> colMiktar;
    @FXML private TableColumn<Malzeme, String> colTur;
    
    //Ürün
    @FXML private TableView<Urun> urunTablosu;
    
    @FXML private Button butonUrunEkle;
    @FXML private Button butonUrunDegistir;
    @FXML private Button butonUrunSil;
    
    @FXML private TableColumn<Urun, Integer> colUrunID;
    @FXML private TableColumn<Urun, String> colUrunAd;
    @FXML private TableColumn<Urun, Double> colFiyat;
    @FXML private TableColumn<Urun, Integer> colStok;
    
    private ObservableList<Malzeme> malListesi=FXCollections.observableArrayList();
    private ObservableList<Urun> urunListesi=FXCollections.observableArrayList();

    
    
    public void tabloMalDoldur(){
        List<Malzeme> veriTabaniMallari=malRepo.malListele();
        
        malListesi.clear();
        malListesi.addAll(veriTabaniMallari);
        
        malzemeTablosu.setItems(malListesi);
        
    }
    
    @FXML void handleMalEkle(ActionEvent event){
        try{
           FXMLLoader loader=new FXMLLoader(getClass().getResource("MalzemeEkle.fxml"));
           Parent root=loader.load();
           
           Stage stage=new Stage();
           stage.setTitle("Yeni malzeme ekle");
           stage.setScene(new Scene(root));
           
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.initOwner(butonMalEkle.getScene().getWindow());
           stage.showAndWait();
           
           tabloMalDoldur();
        }catch(IOException e){
           System.err.println("MalzemeEkle.fxml dosyası yüklenirken hata oluştu.");
           e.printStackTrace();
        }
    }
    
    @FXML void handleMalDegistir(ActionEvent event){
        Malzeme seciliMal=malzemeTablosu.getSelectionModel().getSelectedItem();
        
        if(seciliMal==null){
           System.out.println("Güncelleme için satır seçiniz.");
           return;
        }
        
        try{
           FXMLLoader loader=new FXMLLoader(getClass().getResource("MalzemeEkle.fxml"));
           Parent root=loader.load();
            
           MalzemeEkleController malController=loader.getController();
           malController.veriyiYukle(seciliMal);
            
           Stage stage=new Stage();
           stage.setTitle("Malzeme güncelle");
           stage.setScene(new Scene(root));
           stage.initModality( Modality.APPLICATION_MODAL);
           stage.initOwner(butonMalDegistir.getScene().getWindow());
           stage.showAndWait();
            
           tabloMalDoldur();
        }catch(IOException e){
           System.err.println("MalzemeEkle.fxml doyası yüklenirken hata oluştu.");
           e.printStackTrace();
        }
    }
    
    @FXML void handleMalSil(ActionEvent event){
        Malzeme seciliMal=malzemeTablosu.getSelectionModel().getSelectedItem();
        
        if(seciliMal!=null){
           malRepo.malSil(seciliMal.getId());
           tabloMalDoldur();
        }else{
           System.out.println("Silmek için lütfen satır seçin.");
        }
    }
    
    
    public void tabloUrunDoldur(){
        List<Urun> veriTabaniUrunleri=urunRepo.urunListele();
        
        
        System.out.println("Veri tabanından çekilen ürün sayısı:"+veriTabaniUrunleri.size());
        
        urunListesi.clear();;
        urunListesi.addAll(veriTabaniUrunleri);
        
        urunTablosu.setItems(urunListesi);
    }
    
    @FXML void handleUrunEkle(ActionEvent event){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("UrunEkle.fxml"));
            Parent root=loader.load();
            
            Stage stage=new Stage();
            stage.setTitle("Yeni ürün ekle");
            stage.setScene(new Scene(root));
            
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(butonUrunEkle.getScene().getWindow());
            stage.showAndWait();
            
            tabloUrunDoldur();
        }catch(IOException e){
            System.err.println("UrunEkle.fxml doyası yüklenirken hata oluştu.");
            e.printStackTrace();
        }
    }
    
    @FXML void handleUrunDegistir(ActionEvent event){
        Urun seciliUrun=urunTablosu.getSelectionModel().getSelectedItem();
        
        if(seciliUrun==null){
            System.out.println("Güncelleme için satır seçiniz.");
            return;
        }
        
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("UrunEkle.fxml"));
            Parent root=loader.load();
            
            UrunEkleController urunController=loader.getController();
            urunController.veriyiYukle(seciliUrun);
            
            Stage stage=new Stage();
            stage.setTitle("Ürün güncelle");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(butonUrunDegistir.getScene().getWindow());
            stage.showAndWait();
            
            tabloUrunDoldur();
        }catch(IOException e){
            System.err.println("UrunEkle.fxml dosyası yüklenirken hata oluştu.");
            e.printStackTrace();
        }
    }
    
    @FXML void handleUrunSil(ActionEvent event){
       Urun seciliUrun=urunTablosu.getSelectionModel().getSelectedItem();
       
       if(seciliUrun!=null){
           urunRepo.urunSil(seciliUrun.getId());
           tabloUrunDoldur();
       }else{
           System.out.println("Silmek için satır seçiniz.");
       }
    }
    
    
    
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Stok yönetimi Controller başlatıldı.");
        
        colMalID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMalAd.setCellValueFactory(new PropertyValueFactory<>("ad"));
        colMiktar.setCellValueFactory(new PropertyValueFactory<>("miktar"));
        colTur.setCellValueFactory(new PropertyValueFactory<>("tur"));
        //İsimlendirme Malzeme.java ve Urun.java dosyasındaki değişken adı olacak şekilde ayarlı
        colUrunID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUrunAd.setCellValueFactory(new PropertyValueFactory<>("ad"));
        colFiyat.setCellValueFactory(new PropertyValueFactory<>("fiyat"));
        colStok.setCellValueFactory(new PropertyValueFactory<>("stok"));
        
        tabloMalDoldur();
        tabloUrunDoldur();
    }    
}