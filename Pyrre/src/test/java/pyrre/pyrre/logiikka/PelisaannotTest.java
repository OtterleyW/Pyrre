/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.logiikka;

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
public class PelisaannotTest {

    private Pelisaannot saannot;
    private Korttipakka pakka;
    private Pelialusta alusta;
    private Pelilogiikka logiikka;

    public PelisaannotTest() {
        this.pakka = new Korttipakka();
        this.alusta = new Pelialusta(pakka);
        this.logiikka = new Pelilogiikka();
    }

    @Before
    public void setUp() {
        pakka.LuoKorttipakka();
        alusta.asetaKortitPoydalle();
        this.saannot = new Pelisaannot(alusta);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void haeAlaVasenKorttiPalauttaaOikeanKortin() {
        Kortti kortti = alusta.valitseKortti(0, 6);
        Kortti vasen = saannot.haeAlaVasenKortti(kortti);

        assertEquals(" Risti 2 ", vasen.toString());
    }

    @Test
    public void haeAlaOikeaKorttiPalauttaaOikeanKortin() {
        Kortti kortti = alusta.valitseKortti(0, 6);
        Kortti oikea = saannot.haeAlaOikeaKortti(kortti);

        assertEquals(" Risti 3 ", oikea.toString());
    }

    @Test
    public void voikoKortinValitaToimiiKunKorttiVapaaJaRiviKuusi() {
        Kortti kortti = alusta.valitseKortti(6, 0);
        boolean arvo = saannot.voikoKortinValita(kortti);

        assertEquals(true, arvo);
    }

    @Test
    public void voikoKortinValitaToimiiKunKorttiVapaa() {
        alusta.asetaTyhjaKortti(6, 0);
        alusta.asetaTyhjaKortti(6, 2);

        Kortti kortti = alusta.valitseKortti(5, 1);
        boolean arvo = saannot.voikoKortinValita(kortti);

        assertEquals(true, arvo);
    }

    @Test
    public void voikoKortinValitaToimiiKunKorttiVarattu() {
        Kortti kortti = alusta.valitseKortti(0, 6);
        boolean arvo = saannot.voikoKortinValita(kortti);

        assertEquals(false, arvo);
    }

}
