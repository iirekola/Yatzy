package yatzy;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iiris
 */
public class TaulukkoTest {
    
    public TaulukkoTest() {
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
        Taulukko t = new Taulukko();

        assertEquals(t.getPisteet().length, 17);
    }
    
    @Test
    public void konstruktoriAlustaaPistetaulukon() {
        Taulukko t = new Taulukko();

        assertEquals(t.getPisteet()[10], -1);
    }
    
    @Test
    public void alustaPisteetAsettaaArvot() {
        Taulukko t = new Taulukko();
        boolean toimii = true;
        
        for (int piste : t.getPisteet()) {
            if(piste != -1) {
                toimii = false;
            }
        }

        assertTrue(toimii);
    }
}
