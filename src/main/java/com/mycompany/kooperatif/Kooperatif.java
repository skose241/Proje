/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kooperatif;

import atlantafx.base.theme.PrimerLight;

import com.mycompany.kooperatif.model.Malzeme;
import com.mycompany.kooperatif.repository.MalzemeRepository;
import com.mycompany.kooperatif.repository.VeritabaniBaglanti;
import com.mycompany.kooperatif.model.Urun;
import com.mycompany.kooperatif.repository.UrunRepository;
import com.mycompany.kooperatif.model.Urun;
import com.mycompany.kooperatif.repository.UrunRepository;
import com.mycompany.kooperatif.model.UrunRecete;
import com.mycompany.kooperatif.repository.UrunReceteRepository;
import com.mycompany.kooperatif.servis.UretimServisi;

import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Kooperatif extends Application{

    public static void main(String[] args) {
        try{
        VeritabaniBaglanti.veritabaniOlustur();
        System.out.println("Veri tabanı hazır,kooperatif sistemi başlatılıyor.");
        
        MalzemeRepository malRepo=new MalzemeRepository();
        UrunRepository urunRepo=new UrunRepository();
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        launch(args);
    }
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        try{
            Parent root=FXMLLoader.load(getClass().getResource("/com/mycompany/kooperatif/controller/AnaMenu.fxml"));
            
            Scene scene=new Scene(root);
            
            primaryStage.setTitle("Kooperatif Yönetim Sistemi-Ana Menü");
            
            primaryStage.setScene(scene);
            
            primaryStage.show();
        }catch(Exception e){
            System.err.println("HATA:AnaMenu.fxml dosyası yüklenemedi");
            System.err.println("Hata detayı:"+e.getMessage());
            e.printStackTrace();
        }
    }

    
}
