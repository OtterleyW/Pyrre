/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.logiikka;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;

/**
 *
 * @author Jenni
 */
public class PelilogiikkatTest {

    private Korttipakka pakka;
    private Pelialusta pelialusta;
    private Pelilogiikka logiikka;
    private Pelisaannot saannot;
    private ArrayList<Kortti> valitut;

    @Before
    public void setUp() {
        this.logiikka = new Pelilogiikka();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelinKaynnistysLuoSekoitetunPelipakan() {
        assertNull(logiikka.getPelipakka());
        logiikka.pelinKaynnistys();
        assertNotNull(logiikka.getPelipakka());

        ArrayList<Kortti> pakka = logiikka.getPelipakka().getPakka();

        int edellinen = -1;
        boolean eriLoytynyt = false;

        for (Kortti kortti : pakka) {
            int arvo = kortti.getArvo();
            if (edellinen != -1) {
                if ((edellinen + 1) != arvo && (edellinen - 12) != arvo) {
                    eriLoytynyt = true;
                }
            }
            edellinen = arvo;
        }

        assertEquals(true, eriLoytynyt);
    }

    @Test
    public void pelinKaynnistusLuoPelialustan() {
        assertNull(logiikka.getPelialusta());
        logiikka.pelinKaynnistys();
        assertNotNull(logiikka.getPelialusta());
        //Tarkistetaan onko kortit asetettu pöydälle
        assertNotNull(logiikka.getPelialusta().valitseKortti(1, 6));
    }

    @Test
    public void poydaltaVoiValitaSallitunKortin() {
        logiikka.pelinKaynnistys();
        assertEquals(0, logiikka.getValittujenMaara());
        Kortti kortti = logiikka.getPelialusta().valitseKortti(6, 0);
        logiikka.valitsePoydaltaKortti(kortti);

        if (kortti.getArvo() == 13) {
            assertEquals("poistettu", kortti.getPaikka());
        } else {
            assertEquals(1, logiikka.getValittujenMaara());
        }
    }

    @Test
    public void poydaltaEiVoiValitaEiSallittuaKorttia() {
        logiikka.pelinKaynnistys();
        assertEquals(0, logiikka.getValittujenMaara());
        Kortti kortti = logiikka.getPelialusta().valitseKortti(0, 6);
        logiikka.valitsePoydaltaKortti(kortti);
        assertEquals(0, logiikka.getValittujenMaara());
    }

    @Test
    public void pakastaVoiValitaKortin() {
        logiikka.pelinKaynnistys();
        assertEquals(0, logiikka.getValittujenMaara());
        Kortti kortti = logiikka.getPelipakka().nostaPaalimmainen();
        logiikka.valitsePakastaKortti(kortti);

        if (kortti.getArvo() == 13) {
            assertEquals("poistettu", kortti.getPaikka());
        } else {
            assertEquals(1, logiikka.getValittujenMaara());
        }
    }

    @Test
    public void valitseKorttiToimiiKunKorttiOnKuningas() {
        logiikka.pelinKaynnistys();
        Kortti kortti = new Kortti(13, 0);
        logiikka.valitseKortti(kortti);
        assertEquals(0, logiikka.getValittujenMaara());
        assertEquals("poistettu", kortti.getPaikka());
    }

    @Test
    public void valitseKorttiToimiiKunKortteinSummaOn13() {
        logiikka.pelinKaynnistys();
        Kortti kortti1 = new Kortti(6, 0);
        Kortti kortti2 = new Kortti(7, 0);

        logiikka.valitseKortti(kortti1);
        logiikka.valitseKortti(kortti2);
        assertEquals(0, logiikka.getValittujenMaara());
        assertEquals("poistettu", kortti1.getPaikka());
        assertEquals("poistettu", kortti2.getPaikka());

    }

    @Test
    public void onkoKorttiValittuToimii() {
        logiikka.pelinKaynnistys();
        Kortti kortti = new Kortti(10, 0);
        logiikka.valitseKortti(kortti);

        boolean onko = logiikka.onkoKorttiValittu(kortti);
        System.out.println(logiikka.getValittujenMaara());
        assertEquals(true, onko);

    }

}
