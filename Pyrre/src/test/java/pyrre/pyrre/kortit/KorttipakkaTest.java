package pyrre.pyrre.kortit;

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
         
         assertEquals(52, pakka.TarkistaPakanKoko());
     }
     
     @Test
     public void TarkistaPakanKokoToimii() {
         pakka.LuoKorttipakka();
         pakka.nostaPaalimmainen();
         pakka.nostaPaalimmainen();
         
         assertEquals(50, pakka.TarkistaPakanKoko());
     }
     
     @Test
     public void sekoitaKorttipakkaToimii() {
         pakka.LuoKorttipakka();
         Kortti kortti1 = pakka.getPakka().get(5);
         pakka.sekoitaKorttipakka();
         Kortti kortti2 = pakka.getPakka().get(5);
         
         boolean arvo = false;
         
         if(kortti1.getArvo() == kortti2.getArvo() && kortti1.getMaa() == kortti2.getMaa()){
             arvo = true;
         }
         
         assertEquals(false, arvo);
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
         
         assertEquals(51, pakka.TarkistaPakanKoko());
     }
     
     @Test
     public void asetaPoistopakkaanToimii() {
         pakka.LuoKorttipakka();
         Kortti kortti = pakka.nostaPaalimmainen();
         pakka.asetaPoistopakkaan(kortti);
         
         assertEquals(1, pakka.getPoistopakka().size());
     }
    
}
