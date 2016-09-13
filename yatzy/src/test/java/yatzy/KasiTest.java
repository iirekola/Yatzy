
package yatzy;

import java.util.ArrayList;
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
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        arvot.add(1);
        arvot.add(11);
        Noppa n = new Noppa(arvot);
        Kasi k = new Kasi(n, 5);
        
        assertEquals(k.getNopat().length, 5);
    }
    
    @Test
    public void luotuTaulukkoTaytetty() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        Noppa n = new Noppa(arvot);
        Kasi k = new Kasi(n, 1);
        
        assertEquals(k.getNopat()[0], 6);
    }
}
