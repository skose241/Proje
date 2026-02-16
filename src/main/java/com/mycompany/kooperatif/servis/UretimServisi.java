/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kooperatif.servis;

import com.mycompany.kooperatif.model.Malzeme;
import com.mycompany.kooperatif.repository.MalzemeRepository;
import com.mycompany.kooperatif.model.Urun;
import com.mycompany.kooperatif.repository.UrunRepository;
import com.mycompany.kooperatif.model.UrunRecete;
import com.mycompany.kooperatif.repository.UrunReceteRepository;

import java.util.List;
public class UretimServisi {
    private MalzemeRepository malRepo=new MalzemeRepository();
    private UrunRepository urunRepo=new UrunRepository();
    private UrunReceteRepository receteRepo=new UrunReceteRepository();
    
    public boolean uretimYap(int urunID,int adet){
        List<UrunRecete> receteListesi=receteRepo.getReceteByUrunID(urunID);
        
        if(receteListesi.isEmpty()){
            System.out.println("HATA:Reçete tanımlanmamış");
            return false;
        }
        
        for(UrunRecete recete:receteListesi){
            Malzeme mal=malRepo.getMalzemeByID(recete.getMalID());
            int gerekliMiktar=recete.getMiktar()*adet;
            
            if(mal.getMiktar()<gerekliMiktar){
                System.out.println("Yetersiz stok:"+mal.getAd()+"Gerekli miktar="+(gerekliMiktar-mal.getMiktar()));
                return false;
            }
        }
        
        System.out.println("Stok yeterli. Üretim başlıyor..");
        for (UrunRecete recete:receteListesi){
            Malzeme mal=malRepo.getMalzemeByID(recete.getMalID());
            int dusulecekMiktar=recete.getMiktar()*adet;
            
            mal.setMiktar(mal.getMiktar()-dusulecekMiktar);
            
            malRepo.malGuncelle(mal);
        }
        
        Urun urun=urunRepo.getUrunByID(urunID);
        urun.setStok(urun.getStok()+adet);
        
        urunRepo.urunGuncelle(urun);
        
        return true;
    }
}
