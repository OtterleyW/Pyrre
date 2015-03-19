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
        pakka = teePelipakka(); 
        pelialusta = luoPelialusta();
        System.out.println("Pelialusta luotu");
        pelialusta.tulostaPoyta();
        
    }

    //Luo uuden pelipakan ja sekoittaa pakan kortit
    public Korttipakka teePelipakka() {
        Korttipakka pakka = new Korttipakka();
        pakka.LuoKorttipakka();
        pakka.sekoitaKorttipakka();

        return pakka;
    }
    
    //Luo uuden pelialustan ja asettaa kortit pöydälle
    public Pelialusta luoPelialusta() {
    Pelialusta pelialusta = new Pelialusta(pakka);
    pelialusta.asetaKortitPoydalle();
    return pelialusta;
    }    
    

   }


