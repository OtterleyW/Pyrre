/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.logiikka;

import java.util.ArrayList;
import pyrre.pyrre.Kortti;
import pyrre.pyrre.Korttipakka;

/**
 *
 * @author Jenni
 */
public class Pelilogiikka {

    public void pelinKaynnistys() {
        Korttipakka pakka = teePelipakka();
        asetaKortitPoydalle(pakka);
    }

    public Korttipakka teePelipakka() {
        Korttipakka pakka = new Korttipakka();
        pakka.LuoKorttipakka();
        pakka.sekoitaKorttipakka();

        return pakka;
    }

    public void asetaKortitPoydalle(Korttipakka pakka) {
        for (int i = 0; i <= 28; i++) {

            Kortti kortti = pakka.palautaTiettyKortti(i);

            String paikka = "poyta";
            kortti.asetaUusiPaikka(paikka);

        }
        
        
    }
    
    

   

}
