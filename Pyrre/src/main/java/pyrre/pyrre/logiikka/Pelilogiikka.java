package pyrre.pyrre.logiikka;

import java.util.ArrayList;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;

/**
 *
 * @author Jenni
 */
public class Pelilogiikka {
    private Korttipakka pakka;
    private Pelialusta pelialusta;
    private Pelisaannot saannot;
    
//Käynnistää pelin
    public void pelinKaynnistys() {
        this.pakka = teePelipakka(); 
        this.pelialusta = luoPelialusta();
        System.out.println("Pelialusta luotu");
        this.pelialusta.tulostaPoyta();
        this.saannot = new Pelisaannot(pelialusta);
    }

    //Luo uuden pelipakan ja sekoittaa pakan kortit
    public Korttipakka teePelipakka() {
        Korttipakka pakka = new Korttipakka();
        pakka.LuoKorttipakka();
        pakka.sekoitaKorttipakka();

        return pakka;
    }
    
    //Palauttaa pelipakan
    public Korttipakka getPelipakka(){
        return this.pakka;
    }
    
    //Luo uuden pelialustan ja asettaa kortit pöydälle
    public Pelialusta luoPelialusta() {
    Pelialusta pelialusta = new Pelialusta(pakka);
    pelialusta.asetaKortitPoydalle();
    return pelialusta;
    }
    
    //Valitsee pelattavat kortit ja tarkastaa niiden summan, 
    //jos summa on 13 muuttuu korttien paikka
    public void valitseKortit(Kortti kortti1, Kortti kortti2){
        
        if(this.saannot.voikoKortinValita(kortti1) && this.saannot.voikoKortinValita(kortti2)){
            if(kortti1.getArvo()+kortti2.getArvo() == 13){
                muutaPaikka(kortti1);
                muutaPaikka(kortti2);
                
            }
        }
        
    }
    
    //Jos korttein summa on 13 poistetaan kortit pelistä. 
    //Pöydällä olevan kortin tilalle asetetaan tyhjä kortti, pakassa oleva kortti poistetaan
    public void muutaPaikka(Kortti kortti){
        if(kortti.getPaikka() == "poyta"){
            int i = kortti.getRivi();
            int j = kortti.getSarake();
            
            pelialusta.asetaTyhjaKortti(i, j);
            kortti.asetaPaikka("poistettu");
        }
        
        if(kortti.getPaikka() == "pakka"){
            pakka.poistaKortti(kortti);
        }
            
    }
    
    //Siirtää pakan päälimmäisen kortin poistopakkaan
    public void selaaPakkaa(){
        Kortti kortti = pakka.nostaPaalimmainen();
        pakka.asetaPoistopakkaan(kortti);
    }
    

   }


