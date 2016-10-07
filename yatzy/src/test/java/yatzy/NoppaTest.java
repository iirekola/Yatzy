
package yatzy;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NoppaTest {
    
    public NoppaTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    @Test
    public void konstruktoriAsettaaAlkuarvon() {
        Noppa n = new Noppa();
        
        assertNotNull(n.getArvo());
    }
    
    @Test
    public void konstruktoriAsettaaValitunFalse() {
        Noppa n = new Noppa();
        
        assertFalse(n.getValittu());
    }
    
    @Test
    public void heitaNoppaaAntaaHyvaksyttavanArvon() {
        Noppa n = new Noppa();
        int uusi = n.heitaNoppaa();
        
        assertTrue(1 <= uusi && 6 >= uusi);
    }
    
    @Test
    public void setValittuAsettaaTrue() {
        Noppa n = new Noppa();
        n.setValittu(true);
        
        assertTrue(n.getValittu());
    }
    
    @Test
    public void setValittuAsettaaFalse() {
        Noppa n = new Noppa();
        n.setValittu(false);
        
        assertFalse(n.getValittu());
    }
}
