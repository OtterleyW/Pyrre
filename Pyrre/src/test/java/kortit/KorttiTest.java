
package kortit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pyrre.pyrre.kortit.Kortti;

/**
 *
 * @author Jenni
 */
public class KorttiTest {

    Kortti kortti = new Kortti(10, 3);

    public KorttiTest() {

    }

    @Test
    public void KorttiToStringToimii() {
        assertEquals("Pata 10", kortti.toString());
    }
    
    public void KorttiGetArvoToimii() {
        assertEquals("10", kortti.getArvo());
    }
    
    public void KorttiGetMaaToimii() {
        assertEquals("Pata", kortti.getMaa());
    }
    
    public void KorttiGetPaikkaPalauttaaOletuksenaPakka(){
        assertEquals("pakka", kortti.getPaikka());
    }
    
    public void asetaUusiPaikkaToimii() {
        kortti.asetaUusiPaikka("poyta");
        assertEquals("poyta", kortti.getPaikka());
    }

}
