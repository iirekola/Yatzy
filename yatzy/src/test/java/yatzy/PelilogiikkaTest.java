
package yatzy;

import main.Kayttoliittyma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelilogiikkaTest {
    
    public PelilogiikkaTest() {
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
    public void konstruktoriLuoKaden() {
        Pelilogiikka l = new Pelilogiikka();
        
        assertNotNull(l.getKasi());
    }
    
    @Test
    public void konstruktoriLuoLaskurin() {
        Pelilogiikka l = new Pelilogiikka();
        
        assertNotNull(l.getLaskuri());
    }
    
    @Test
    public void getSilmaluvutToimii() {
        Pelilogiikka l = new Pelilogiikka();
        int[] testi = l.getSilmaluvut();
        boolean toimii = true;
        
        for (int i = 0; i < 5; i++) {
            if (testi[i] != l.getKasi().getNopat()[i].getArvo()) {
                toimii = false;
            }
        }
        
        assertTrue(toimii);
    }
    
    @Test
    public void heitaKaikkiNopatVapauttaaKaikkiNopat() {
        Pelilogiikka l = new Pelilogiikka();
        l.heitaKaikkiNopat();
        boolean toimii = true;
        
        for(Noppa noppa : l.getKasi().getNopat()) {
            if (noppa.getValittu()) {
                toimii = false;
            }
        }
        
        assertTrue(toimii);
    }
    
    @Test
    public void heitaValitutNopatVapauttaaKaikkiNopat() {
        Pelilogiikka l = new Pelilogiikka();
        l.heitaValitutNopat();
        boolean toimii = true;
        
        for(Noppa noppa : l.getKasi().getNopat()) {
            if (noppa.getValittu()) {
                toimii = false;
            }
        }
        
        assertTrue(toimii);
    }
    
    @Test
    public void heitaValitutNopatEiHeitäMuitaNoppia() {
        Pelilogiikka l = new Pelilogiikka();
        int[] ennen = l.getSilmaluvut();
        
        l.valitseNoppa(2);
        l.heitaValitutNopat();
        int[] jalkeen = l.getSilmaluvut();
        boolean toimii = true;
        
        for(int i = 0; i < 5; i++) {
            if (i != 2) {
                if (ennen[i] != jalkeen[i]){
                    toimii = false;
                }
            }
        }
        assertTrue(toimii);
    }
    
    @Test
    public void valitseNoppaToimii() {
        Pelilogiikka l = new Pelilogiikka();
        l.valitseNoppa(2);
        
        assertTrue(l.getKasi().getNopat()[2].getValittu());
    }
}
