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
public class PelilogiikkatTest {
    
    private Korttipakka pakka;
    private Pelialusta pelialusta;
    private Pelilogiikka logiikka;
    private Pelisaannot saannot;
    
    public PelilogiikkatTest() {
    }
    
    
    @Before
    public void setUp() {
        this.logiikka = new Pelilogiikka();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pelinKaynnistysPalauttaaPelipakan(){
        logiikka.pelinKaynnistys();
        assertEquals(24, logiikka.getPelipakka().TarkistaPakanKoko());
    }
    
    @Test
    public void teePelipakkaLuoUudenPakan(){
        Korttipakka pakka = logiikka.teePelipakka();
        assertEquals(52, pakka.TarkistaPakanKoko());
    }
    
    @Test
    public void teePelipakkaSekoittaaPakan(){
         Korttipakka pakka = logiikka.teePelipakka();
         Kortti kortti1 = pakka.nostaPaalimmainen();
         Kortti kortti2 = pakka.nostaPaalimmainen();
         boolean onkoViereinen = false;
         
         if(kortti1.getArvo() == (kortti2.getArvo() - 1) && kortti1.getMaa() == kortti2.getMaa()){
            onkoViereinen = true;
         }
        
         assertEquals(false, onkoViereinen);
    }
    

    

}
