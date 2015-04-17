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
public class PelialustaTest {

    private Korttipakka pakka;
    private Pelialusta alusta;
    private Kortti[][] pelialusta;

    public PelialustaTest() {
        this.pakka = new Korttipakka();
        this.pakka.LuoKorttipakka();
    }

    @Before
    public void setUp() {
        this.alusta = new Pelialusta(this.pakka);
        this.pelialusta = alusta.getPelialusta();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelialustallaOnPakka() {
        assertEquals(52, this.pakka.getPakanKoko());
    }

    @Test
    public void asetaKortitPoydallePienentaaKorttipakkaa() {
        alusta.asetaKortitPoydalle();
        assertEquals(24, this.pakka.getPakanKoko());
    }

    @Test
    public void asetaTyhjaKorttiAsettaaKortin() {
        alusta.asetaTyhjaKortti(0, 0);
        assertEquals("        ", this.pelialusta[0][0].toString());
    }

    @Test
    public void valitseKorttiValitseeKortin() {
        alusta.asetaKortitPoydalle();
        Kortti kortti = alusta.valitseKortti(0, 6);
        assertEquals(" Risti A ", kortti.toString());
    }

    @Test
    public void asetaKortitPoydalleAsettaaTyhjanKortin() {
        alusta.asetaKortitPoydalle();
        Kortti kortti = alusta.valitseKortti(0, 4);
        assertEquals("        ", kortti.toString());
    }

    @Test
    public void asetaKortitPoydalleAsettaaOikeanKortin() {
        alusta.asetaKortitPoydalle();
        Kortti kortti = alusta.valitseKortti(0, 6);
        assertEquals(" Risti A ", kortti.toString());
    }

       

}
