
package yatzy;

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
    public void konstruktoriLuoPelaajalistan() {
        Pelilogiikka l = new Pelilogiikka();
        
        assertNotNull(l.getPelaajat());
    }

    @Test
    public void konstruktoriLuoKaden() {
        Pelilogiikka l = new Pelilogiikka();
        
        assertNotNull(l.getKasi());
    }
    
//    @Test
//    public void aloitaPeli()
//    } 
}
