package pyrre.pyrre.kortit;

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
public class KorttipakkaTest {

    Korttipakka pakka = new Korttipakka();

    public KorttipakkaTest() {
    }

    @Test
    public void LuoKorttipakkaTekee52Korttia() {
        pakka.LuoKorttipakka();

        assertEquals(52, pakka.getPakanKoko());
    }

    @Test
    public void TarkistaPakanKokoToimii() {
        pakka.LuoKorttipakka();
        pakka.nostaPaalimmainen();
        pakka.nostaPaalimmainen();

        assertEquals(50, pakka.getPakanKoko());
    }

    @Test
    public void sekoitaKorttipakkaToimii() {
        pakka.LuoKorttipakka();
        Object[] sekoittamattomatKortit = pakka.getPakka().toArray();
        pakka.sekoitaKorttipakka();
        Object[] sekoitetutKortit = pakka.getPakka().toArray();

        assertFalse("Pakka ei ole sekoitettu", Arrays.equals(sekoittamattomatKortit, sekoitetutKortit));
    }

    @Test
    public void nostaPaalimmainenToimii() {
        pakka.LuoKorttipakka();
        Kortti kortti = pakka.nostaPaalimmainen();

        assertEquals(" Risti A ", kortti.toString());
    }

    @Test
    public void nostaPaalimmainenPoistaaKortinPakasta() {
        pakka.LuoKorttipakka();
        pakka.nostaPaalimmainen();

        assertEquals(51, pakka.getPakanKoko());
    }

    @Test
    public void getPoistopakkaPalauttaaPoistopakan() {
        pakka.LuoKorttipakka();
        pakka.nostaPaalimmainen();

        ArrayList<Kortti> poistetut = pakka.getPoistopakka();

        assertEquals(poistetut, pakka.getPoistopakka());

    }

    @Test
    public void nostaPaalimmainenToimiiKunTaysiPakka() {
        pakka.LuoKorttipakka();
        pakka.nostaPaalimmainen();

        assertEquals(1, pakka.getKerrat());
        assertEquals(1, pakka.getPoistopakka().size());
        assertEquals(51, pakka.getPakanKoko());
    }

    @Test
    public void nostaPaalimmainenToimiiKunPakkaKaytyLapiKerranJaNostetaanYksi() {
        pakka.LuoKorttipakka();

        for (int i = 0; i <52; i++) {
            pakka.nostaPaalimmainen();
        }

        assertEquals(1, pakka.getKerrat());
        assertEquals(52, pakka.getPoistopakka().size());
        assertEquals(0, pakka.getPakanKoko());

    }
    
    @Test
    public void nostaPaalimmainenToimiiKunPakastaNostetaanViimeinenKortti() {
        pakka.LuoKorttipakka();

        for (int i = 0; i <= 52; i++) {
            pakka.nostaPaalimmainen();
        }

        assertEquals(2, pakka.getKerrat());
        assertEquals(1, pakka.getPoistopakka().size());
        assertEquals(51, pakka.getPakanKoko());

    }
    
    @Test
    public void nostaPaalimmainenToimiiKunPakkaKaytyLapiKolmesti() {
       pakka.LuoKorttipakka();
       pakka.setKerrat(3);
       
       Kortti kortti = new Kortti(1,1);
       
       for (int i = 0; i <52; i++) {
           kortti = pakka.nostaPaalimmainen();
       }
       
       assertEquals(3, pakka.getKerrat());
       assertEquals("loppu", kortti.getPaikka());
       assertEquals(0, pakka.getPakanKoko());
       
       Kortti vika = pakka.nostaPaalimmainen();
       
       assertEquals(0, pakka.getPakanKoko());
       assertNull(vika);

    }

}
