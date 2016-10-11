
package yatzy;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KasiTest {
    
    public KasiTest() {
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void luotuTaulukkoOikeanKokoinen() {
        Kasi k = new Kasi();
        
        assertEquals(k.getNopat().length, 5);
    }
    
    @Test
    public void luotuTaulukkoTaytetty() {
        Kasi k = new Kasi();
        
        assertNotNull(k.getNopat()[4]);
    }
    
    @Test
    public void heitaValitutNopatToimii() {
        Kasi k = new Kasi();
        int arvo2 = k.getNopat()[2].getArvo();
        k.valitseNoppa(3, true);
        k.heitaValitutNopat();
        
        assertEquals(k.getNopat()[2].getArvo(), arvo2);
    }
    
    @Test
    public void valitseNoppaToimii() {
        Kasi k = new Kasi();
        k.valitseNoppa(2, true);
        boolean toimii = true;
        
        for (Noppa noppa : k.getNopat()) {
            if (noppa == k.getNopat()[2]) {
                toimii = noppa.getValittu();
            }
            else {
                if (noppa.getValittu()) {
                    toimii = false;
                }
            }
        }
        
        assertTrue(toimii);
    }
    
    @Test
    public void vapautaNoppaToimii() {
        Kasi k = new Kasi();
        k.valitseNoppa(2, true);
        k.valitseNoppa(2, false);
        
        assertFalse(k.getNopat()[2].getValittu());
    }
    
    @Test
    public void vapautaKaikkiNopatToimii() {
        Kasi k = new Kasi();
        k.valitseNoppa(2, true);
        k.vapautaKaikkiNopat();
        
        assertFalse(k.getNopat()[2].getValittu());
    }
    
    @Test
    public void getSilmaluvutPalauttaaTaulukon() {
        Kasi k = new Kasi();
        int[] t = k.getSilmaluvut();
        
        assertFalse(t == null);
    }
    
    @Test
    public void getSilmaluvutKaikkiSilmaluvutOikealtaValilta() {
        Kasi k = new Kasi();
        int[] t = k.getSilmaluvut();
        boolean toimii = true;
        
        for (int i : t) {
            if (i < 1 || i > 6) {
                toimii = false;
            }
        }
        
        assertTrue(toimii);
    }
}
