/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;
import pyrre.pyrre.logiikka.Pelialusta;
import pyrre.pyrre.logiikka.Pelilogiikka;
import pyrre.pyrre.ui.Kayttoliittyma;
/**
 *
 * @author Jenni
 */
public class Paaohjelma {
/**
 * Pääohjelma käynnistää ohjelman
 * @param args 
 */   
    public static void main(String[] args) {
        Pelilogiikka peli = new Pelilogiikka();
        peli.pelinKaynnistys();
        Pelialusta alusta = peli.getPelialusta();
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(alusta, peli);
        SwingUtilities.invokeLater(kayttoliittyma);

        
       
        

        

    }
    
    public static void aloitaUusiPeli() {
        Pelilogiikka peli = new Pelilogiikka();
        peli.pelinKaynnistys();
        Pelialusta alusta = peli.getPelialusta();
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(alusta, peli);
        SwingUtilities.invokeLater(kayttoliittyma);
    }

  
}
