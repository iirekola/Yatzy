/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yatzy;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iirekola
 */
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
    public void konstrukstoriAsettaaArvotOikeinKunYksiArvo() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        Noppa n = new Noppa(arvot);
        
        assertEquals(n.getArvot(), arvot);
    }
    
    @Test
    public void konstrukstoriAsettaaArvotOikeinKunUseampiArvo() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        arvot.add(1);
        arvot.add(11);
        Noppa n = new Noppa(arvot);
        
        assertEquals(n.getArvot(), arvot);
    }
    
    @Test
    public void konstrukstoriAsettaaAlkuarvonKunYksiArvo() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        Noppa n = new Noppa(arvot);
        
        assertEquals(n.getArvo(), 6);
    }
    
    @Test
    public void konstrukstoriAsettaaAlkuarvonKunUseampiArvo() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        arvot.add(1);
        arvot.add(11);
        Noppa n = new Noppa(arvot);
        
        assertTrue(arvot.contains(n.getArvo()));
    }
    
    @Test
    public void luotuNoppaEiLukittu() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        Noppa n = new Noppa(arvot);
        
        assertFalse(n.onkoLukittu());
    }
    
    @Test
    public void uusiArvoAntaaHyvaksyttavanArvonKunYksiArvo() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        Noppa n = new Noppa(arvot);
        int uusi = n.uusiArvo();
        
        assertEquals(uusi, 6);
    }
    
    @Test
    public void uusiArvoAntaaHyvaksyttavanArvonKunUseampiArvo() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        arvot.add(1);
        arvot.add(11);
        Noppa n = new Noppa(arvot);
        int uusi = n.uusiArvo();
        
        assertTrue(arvot.contains(uusi));
    }
    
    @Test
    public void heitaNoppaaAntaaHyvaksyttavanArvonKunYksiArvo() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        Noppa n = new Noppa(arvot);
        n.heitaNoppaa();
        
        assertEquals(n.getArvo(), 6);
    }
    
    @Test
    public void heitaNoppaaAntaaHyvaksyttavanArvonKunUseampiArvo() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        arvot.add(1);
        arvot.add(11);
        Noppa n = new Noppa(arvot);
        n.heitaNoppaa();
        
        assertTrue(arvot.contains(n.getArvo()));
    }
    
    @Test
    public void lukitseToimii() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        Noppa n = new Noppa(arvot);
        n.lukitse();
        
        assertTrue(n.onkoLukittu());
    }
    
    @Test
    public void vapautaToimii() {
        ArrayList<Integer> arvot = new ArrayList<Integer>();
        arvot.add(6);
        Noppa n = new Noppa(arvot);
        n.lukitse();
        n.vapauta();
        
        assertFalse(n.onkoLukittu());
    }
    
    
}
