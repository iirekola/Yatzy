
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
    
    @Test
    public void luoPelaajatToimiiKunYksi() {
        Pelilogiikka l  = new Pelilogiikka();
        l.luoPelaajat(1);
        
        assertEquals(l.getPelaajat().size(), 1);
    }
    
    @Test
    public void luoPelaajatToimiiKunEiYhtaan() {
        Pelilogiikka l  = new Pelilogiikka();
        l.luoPelaajat(0);
        
        assertEquals(l.getPelaajat().size(), 0);
    }
    
    @Test
    public void luoPelaajatToimiiKunMonta() {
        Pelilogiikka l  = new Pelilogiikka();
        l.luoPelaajat(3);
        
        assertEquals(l.getPelaajat().size(), 3);
    }
    
    @Test
    public void luoPelaajatAsettaaNimeksiNumeron() {
        Pelilogiikka l  = new Pelilogiikka();
        l.luoPelaajat(1);
        
        assertEquals(l.getPelaajat().get(0).getNimi(), "1");
    }
    
    @Test
    public void nimeaPelaajaToimiiKunNollas() {
        Pelilogiikka l  = new Pelilogiikka();
        l.luoPelaajat(1);
        l.nimeaPelaaja(0, "Pasi");
        
        assertEquals(l.getPelaajat().get(0).getNimi(), "Pasi");
    } 
    
    @Test
    public void nimeaPelaajaEiHyvaksyNegatiivista() {
        Pelilogiikka l  = new Pelilogiikka();
        l.luoPelaajat(1);
        l.nimeaPelaaja(-1, "Pasi");
        
        assertEquals(l.getPelaajat().get(0).getNimi(), "1");
    }
    
    @Test
    public void nimeaPelaajaEiHyvaksyLiianSuurta() {
        Pelilogiikka l  = new Pelilogiikka();
        l.luoPelaajat(1);
        l.nimeaPelaaja(1, "Pasi");
        
        assertEquals(l.getPelaajat().get(0).getNimi(), "1");
    }
}
