/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.logiikka;

import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;

/**
 *
 * @author Jenni
 */
public class Pelialusta {
    private Korttipakka pakka;
    private Kortti[][] poyta;
    
    public Pelialusta(Korttipakka pakka) {
        this.poyta = new Kortti[7][7];
        this.pakka = pakka;
    }
    
    public Kortti[][] getPoyta(){
        poyta = asetaKortitPoydalle(poyta);
        return poyta;
    }
    public Kortti[][] asetaKortitPoydalle(Kortti[][] poyta) {
       Kortti tyhja = new Kortti(1,1);
       tyhja = tyhja.TyhjaKortti();
        
        for (int rivi = 0; rivi < 7; ++rivi) {
            for (int sarake = 0; sarake <7; ++sarake) {
                    if(rivi==0){
                        if(sarake==3){
                            Kortti kortti = nostaKortti();
                            poyta[rivi][sarake] = kortti;
                        }
                        else{
                            poyta[rivi][sarake] = tyhja;
                        }
                    }
                    if(rivi==1){
                        if(sarake==2 || sarake==4){
                            Kortti kortti = nostaKortti();
                            poyta[rivi][sarake] = kortti;
                        }
                    }
                   if(rivi==2){
                       if(sarake >= 3 && sarake <=5){
                           Kortti kortti = nostaKortti();
                            poyta[rivi][sarake] = kortti;
                        }
                        else{
                            poyta[rivi][sarake] = tyhja;
                        }
                   }
                   if(rivi==3){
                        if(sarake >= 1 && sarake <=2 || sarake >=4 && sarake <=5 ){
                           Kortti kortti = nostaKortti();
                            poyta[rivi][sarake] = kortti;
                        }
                        else{
                            poyta[rivi][sarake] = tyhja;
                        }
                    }
                   if(rivi==4){
                       if(sarake >= 1 && sarake <=5){
                           Kortti kortti = nostaKortti();
                            poyta[rivi][sarake] = kortti;
                        }
                        else{
                            poyta[rivi][sarake] = tyhja;
                        }
                   }
                   if(rivi==5){
                        if(sarake == 3 ){
                           poyta[rivi][sarake] = tyhja;
                        }
                        else{
                            Kortti kortti = nostaKortti();
                            poyta[rivi][sarake] = kortti;
                        }
                    }
                   if(rivi==6){
                       Kortti kortti = nostaKortti();
                       poyta[rivi][sarake] = kortti;
                   }
                   
            }
        }
        return poyta;
    }
    
    public Kortti nostaKortti(){
        Kortti kortti = pakka.nostaPaalimmainen();
        return kortti;
    }
    

    


}
