package kortit;

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
     
     public void palautaTiettyKorttiToimii() {
        Kortti kortti = pakka.palautaTiettyKortti(3);
        assertEquals("Risti 4", kortti.toString());
     }
     
     public void nostaPaalimmainen() {
         Kortti kortti = pakka.nostaPaalimmainen();
         assertEquals("Risti A", kortti.toString());
     }
  
}
