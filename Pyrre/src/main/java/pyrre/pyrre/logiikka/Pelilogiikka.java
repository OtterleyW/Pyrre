package pyrre.pyrre.logiikka;

import java.util.ArrayList;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;

/**
 *
 * @author Jenni
 */
public class Pelilogiikka {

//Käynnistää pelin
    public void pelinKaynnistys() {
        Korttipakka pakka = teePelipakka();
        Kortti[][] pelipoyta = LuoUusiPelialusta(pakka);
        tulostaPoyta(pelipoyta);
    }

    //Luo uuden pelipakan ja sekoittaa pakan kortit
    public Korttipakka teePelipakka() {
        Korttipakka pakka = new Korttipakka();
        pakka.LuoKorttipakka();
        pakka.sekoitaKorttipakka();

        return pakka;
    }
    
    public Kortti[][] LuoUusiPelialusta(Korttipakka pakka) {
        Pelialusta alusta = new Pelialusta(pakka);
        Kortti[][] pelipoyta = alusta.getPoyta();
        return pelipoyta;
    }

      public void tulostaPoyta(Kortti[][] poyta){
         for (int rivi = 0; rivi < 7; ++rivi) {
            for (int sarake = 0; sarake <7; ++sarake) {
                System.out.print(poyta[rivi][sarake].toString());
            }
             System.out.println("");
         }
    }

    }


