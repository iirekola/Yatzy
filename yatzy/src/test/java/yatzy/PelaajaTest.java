
package yatzy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelaajaTest {
    
    public PelaajaTest() {
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
    public void konstruktoriLuoPistetaulukon() {
        Pelaaja p = new Pelaaja("testi");
        
        assertNotNull(p.getPisteet());
    }
    
    @Test
    public void konstruktoriAsettaaNimen() {
        Pelaaja p = new Pelaaja("testi");
        
        assertEquals(p.getNimi(), "testi");
    }
    
    @Test
    public void setteriAsettaaNimen() {
        Pelaaja p = new Pelaaja("testi");
        p.setNimi("uusi");
        
        assertEquals(p.getNimi(), "uusi");
    }
}
