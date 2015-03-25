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

//Käynnistää pelin
    public void pelinKaynnistys() {
        this.pakka = teePelipakka(); 
        this.pelialusta = luoPelialusta();
        System.out.println("Pelialusta luotu");
        this.pelialusta.tulostaPoyta();
        
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
    
    //Laskee valitut kortit yhteen
    public void valitseKortit(int rivi1, int sarake1, int rivi2, int sarake2){
        Kortti kortti1 = pelialusta.valitseKortti(rivi1, sarake1);
        Kortti kortti2 = pelialusta.valitseKortti(rivi2, sarake2);
        
    }
    

   }


