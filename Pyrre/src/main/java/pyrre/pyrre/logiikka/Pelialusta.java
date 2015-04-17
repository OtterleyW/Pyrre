package pyrre.pyrre.logiikka;

import java.util.ArrayList;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;

/**
 * Luokka asettaa kortit pelipöydälle ja hallitsee korttien paikkoja
 *
 * @author Jenni
 */
public class Pelialusta {

    private Korttipakka pakka;
    private Kortti[][] pelialusta;

    /**
     * Luo uuden pelialustan
     *
     * @param pakka Pelissä käytettävä korttipakka
     */
    public Pelialusta(Korttipakka pakka) {
        this.pakka = pakka;
        this.pelialusta = new Kortti[7][13];
    }

    /**
     * Asetetaan kortit pyramidin muotoon pöydälle. Taulukon tyhjiin paikkoihin
     * luodaan "tyhjäkortti" null-arvojen välttämiseksi.
     */
    public void asetaKortitPoydalle() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 13; j++) {
                if (i == 0 && j == 6
                        || i == 1 && j == 5 || i == 1 && j == 7
                        || i == 2 && j == 4 || i == 2 && j == 6 || i == 2 && j == 8
                        || i == 3 && j == 3 || i == 3 && j == 5 || i == 3 && j == 7 || i == 3 && j == 9
                        || i == 4 && j == 2 || i == 4 && j == 4 || i == 4 && j == 6 || i == 4 && j == 8 || i == 4 && j == 10
                        || i == 5 && j == 1 || i == 5 && j == 3 || i == 5 && j == 5 || i == 5 && j == 7 || i == 5 && j == 9 || i == 5 && j == 11
                        || i == 6 && j == 0 || i == 6 && j == 2 || i == 6 && j == 4 || i == 6 && j == 6 || i == 6 && j == 8 || i == 6 && j == 10 || i == 6 && j == 12) {
                    asetaKortti(i, j);
                } else {
                    asetaTyhjaKortti(i, j);
                }
            }
        }
    }

    /**
     * Nostetaan korttipakan päälimmäinen kortti ja asetetaan se pöydälle
     *
     * @param i kortin rivi
     * @param j kortin sarake
     */
    public void asetaKortti(int i, int j) {
        Kortti kortti = pakka.nostaPaalimmainen();
        pelialusta[i][j] = kortti;
        kortti.asetaPaikkaPoydalla(i, j);
    }

    /**
     * Asettaa tyhjäm kortin pöydälle
     *
     * @param i kortin rivi
     * @param j kortin sarake
     */
    public void asetaTyhjaKortti(int i, int j) {
        Kortti kortti = luoTyhjaKortti();
        pelialusta[i][j] = kortti;
    }

    /**
     * Luo tyhjän kortin pelialustalle
     *
     * @return tyhjä kortti
     */
    public Kortti luoTyhjaKortti() {
        Kortti tyhja = new Kortti(0, 4);
        tyhja = tyhja.LuoTyhjaKortti();
        return tyhja;
    }

    /**
     * Palauttaa kortin tietystä paikasta
     *
     * @param i kortin rivi
     * @param j kortin sarake
     * @return i:n ja j:n perusteella valittu kortti
     */
    public Kortti valitseKortti(int i, int j) {
        Kortti kortti = pelialusta[i][j];
        return kortti;
    }

    /**
     * Tulostaa pelipöydän (ei tarpeen graafisen käyttöliittymän jälkeen)
     */
    public void tulostaPoyta() {
        for (int i = 0; i < pelialusta.length; i++) {
            for (int j = 0; j < pelialusta[i].length; j++) {
                System.out.print(" " + pelialusta[i][j].toString() + " ");
            }
            System.out.println("");
        }
    }

    public Kortti[][] getPelialusta() {
        return this.pelialusta;
    }

}
