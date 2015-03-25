
package pyrre.pyrre.kortit;

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

    private Kortti kortti;

    public KorttiTest() {

    }
    
    @Before
    public void setUp() {
        kortti = new Kortti(10,3);
    }

    @Test
    public void KorttiToStringToimii() {
        assertEquals("  Pata 10", kortti.toString());
    }
    
    @Test
    public void KorttiGetArvoToimii() {
        assertEquals(10, kortti.getArvo());
    }
    
    @Test
    public void KorttiGetMaaToimii() {
        assertEquals(3, kortti.getMaa());
    }
    
    
    @Test
    public void luoTyhjaKorttiToimii() {
        Kortti tyhja = kortti.LuoTyhjaKortti();
        assertEquals("        ", tyhja.toString());
    }
   
    

}
