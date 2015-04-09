package pyrre.pyrre.logiikka;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;
import pyrre.pyrre.ui.Kayttoliittyma;

/**
 *
 * @author Jenni
 */
public class Pelilogiikka {
    private Korttipakka pakka;
    private Pelialusta pelialusta;
    private Pelisaannot saannot;
    private ArrayList<Kortti> valitut;
    
    
    
//Käynnistää pelin
    public void pelinKaynnistys() {
        this.pakka = teePelipakka(); 
        this.pelialusta = luoPelialusta();
        System.out.println("Pelialusta luotu");
        this.pelialusta.tulostaPoyta();
        this.saannot = new Pelisaannot(pelialusta);
        this.valitut = new ArrayList<Kortti>();
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
    
    
    //Siirtää pakan päälimmäisen kortin poistopakkaan
    public void selaaPakkaa(){
        Kortti kortti = pakka.nostaPaalimmainen();
        pakka.asetaPoistopakkaan(kortti);
    }
    
    public Pelialusta getPelialusta(){
        return this.pelialusta;
    }
    
    public void valitseKortti(Kortti kortti){
        if(saannot.voikoKortinValita(kortti)){
            if(valitut.size()<2){
                valitut.add(kortti);
            }
        }
    }
    
    public int getValittujenMaara(){
        return valitut.size();
    }
    
    public int laskeValitutYhteen(){
         int summa = 0;
         
         for(Kortti kortti : valitut){
             summa += kortti.getArvo();
         }
         
        return summa;
    }
    
    public boolean tarkastaKorttienSumma(int summa){
        if(summa == 13){
            return true;
        }
        
        return false;
    }
    
    public void muutaKortitTyhjaksi(){
        for(Kortti kortti : valitut){
            kortti.asetaPaikka("Poistopakka");
            kortti = kortti.LuoTyhjaKortti();
            
            int i = kortti.getRivi();
            int j = kortti.getArvo();
            
            this.pelialusta.tallennaKortti(i, j, kortti);
                    
        }
        valitut.clear();
    }
    
    
    
   

   }


