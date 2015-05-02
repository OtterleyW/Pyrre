package pyrre.pyrre.logiikka;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;
import pyrre.pyrre.ui.Kayttoliittyma;

/**
 * Pelilogiikka sisältää metodeja joilla hallitaan pelin toimintaa
 *
 * @author Jenni
 */
public class Pelilogiikka {

    private Korttipakka pakka;
    private Pelialusta pelialusta;
    private Pelisaannot saannot;
    private ArrayList<Kortti> valitut;

    /**
     * Käynnistää pelin luomalla pelipakan, pelialustan ja pelisäännöt
     */
    public void pelinKaynnistys() {
        this.pakka = teePelipakka();
        this.pelialusta = luoPelialusta();
        this.saannot = new Pelisaannot(pelialusta);
        this.valitut = new ArrayList<Kortti>();
    }

    /**
     * Luo uuden korttipakan ja sekoittaa pakan kortit
     *
     * @return pelipakka
     */
    private Korttipakka teePelipakka() {
        Korttipakka pakka = new Korttipakka();
        pakka.LuoKorttipakka();
        pakka.sekoitaKorttipakka();

        return pakka;
    }

    public Korttipakka getPelipakka() {
        return this.pakka;
    }

    /**
     * Luo uuden pelialustan ja asettaa kortit pöydälle
     *
     * @return pelialusta
     */
    private Pelialusta luoPelialusta() {
        Pelialusta pelialusta = new Pelialusta(pakka);
        pelialusta.asetaKortitPoydalle();

        this.pelialusta = pelialusta;

        return pelialusta;
    }

    public Pelialusta getPelialusta() {
        return this.pelialusta;
    }

    /**
     * Tarkistaa pelisäännöiltä, voiko käyttäjän pöydältä valitseman kortin
     * valita. Jos voi, kortti valitaan.
     *
     * @param kortti Käyttäjän pöydältä valitsema kortti
     */
    public void valitsePoydaltaKortti(Kortti kortti) {
        if (saannot.voikoKortinValita(kortti)) {
            valitseKortti(kortti);
        }
    }

    /**
     * Valitsee käyttäjän pakasta valitseman kortin.
     *
     * @param kortti Käyttäjän pakasta valitsema kortti
     */
    public void valitsePakastaKortti(Kortti kortti) {
        valitseKortti(kortti);
    }

    /**
     * Tarkistetaan valittujen, että valittu kortti tallennetaan ja se
     * poistetaanko valitut kortit pelistä vai pitääkö valita lisää kortteja
     *
     * @param kortti Valittu kortti
     */
    public void valitseKortti(Kortti kortti) {
        if (valitut.size() < 2) {
            valitut.add(kortti);

            if (kortti.getArvo() == 13) {
                poistaVikaValittuKortti();
                tyhjennaValitut();
            }
            
            if (getValittujenMaara() == 2) {
                int summa = laskeValitutYhteen();
                if (summa == 13) {
                    poistaValitutKortit();
                }
                tyhjennaValitut();
            }
        }
    }

    public int getValittujenMaara() {
        return valitut.size();
    }

    /**
     * Laskee valitut-listalla olevien korttien aarvojen summan yhteen
     *
     * @return korttien arvojen summa
     */
    private int laskeValitutYhteen() {
        int summa = 0;
        for (Kortti kortti : valitut) {
            summa += kortti.getArvo();
        }
        return summa;
    }

    /**
     * Muuttaa valittujen korttien paikaksi "poistettu"
     */
    public void poistaValitutKortit() {
        System.out.println(valitut);
        
        for (Kortti kortti : valitut) {
            kortti.poista();
        }
    }
    
    private void poistaVikaValittuKortti() {
        valitut.get(valitut.size() - 1).poista();
    }

    /**
     * Tyhjentää valittujen korttien listan
     */
    public void tyhjennaValitut() {
        valitut.clear();
    }
   
}
