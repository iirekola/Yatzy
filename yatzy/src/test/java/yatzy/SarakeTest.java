
package yatzy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SarakeTest {
    
    public SarakeTest() {
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
    public void konstruktorAsettaaArvonOikein() {
        Sarake s = new Sarake();
        
        assertEquals(s.getPisteet(), -1);
    }
    
    @Test
    public void merkitsePisteetToimii() {
        Sarake s  = new Sarake();
        s.merkitsePisteet(5);
        
        assertEquals(s.getPisteet(), 5);
    }
}
