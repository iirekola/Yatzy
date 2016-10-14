package yatzy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaskuriTest {

    public LaskuriTest() {
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
    public void konstruktoriAsettaaKaden() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);

        assertEquals(l.getKasi(), k);
    }
    
    @Test
    public void laskeSarakkeenPisteetPalauttaaOikeinKunValisumma() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        int pisteet = l.laskeSarakkeenPisteet(6);

        assertEquals(pisteet, -1);
    }
    
    @Test
    public void laskeSarakkeenPisteetPalauttaaOikeinKunSumma() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        int pisteet = l.laskeSarakkeenPisteet(16);

        assertEquals(pisteet, -1);
    }
    
    @Test
    public void laskeSarakkeenPisteetPalauttaaOikeinKunSarakkeessaJoTulos() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        l.laskeSarakkeenPisteet(2);
        int pisteet = l.laskeSarakkeenPisteet(2);

        assertEquals(pisteet, -1);
    }
    
    @Test
    public void laskeSarakkeenPisteetEiTallennaJosHuonoSarake() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        l.laskeSarakkeenPisteet(6);

        assertEquals(l.getPisteet().getSarake(6), -1);
    }
    
    @Test
    public void laskeSarakkeenPisteetTallentaaPisteet() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        l.laskeSarakkeenPisteet(2);

        assertTrue(l.getPisteet().getSarake(2) >= 0 && l.getPisteet().getSarake(2) < 16);
    }
    
    @Test
    public void laskeSarakkeenPaivittaaValisumman() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        l.laskeSarakkeenPisteet(2);

        assertTrue(l.getPisteet().getSarake(6) >= 0 && l.getPisteet().getSarake(2) < 16);
    }
    
    @Test
    public void laskeSarakkeenPaivittaaSumman() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        l.laskeSarakkeenPisteet(2);

        assertTrue(l.getPisteet().getSarake(16) >= 0 && l.getPisteet().getSarake(2) < 16);
    }
    
    @Test
    public void voiTallentaaPalauttaaFalseJosVälisumma() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);

        assertFalse(l.voiTallentaa(6));
    }
    
    @Test
    public void voiTallentaaPalauttaaFalseJosSumma() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);

        assertFalse(l.voiTallentaa(16));
    }
    
    @Test
    public void voiTallentaaPalauttaaFalseJosSarakkeessaJoTulos() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        l.laskeSarakkeenPisteet(3);

        assertFalse(l.voiTallentaa(3));
    }
    
    @Test
    public void voiTallentaaPalauttaaTrueJosVoiTallentaa() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);

        assertTrue(l.voiTallentaa(4));
    }
    
    @Test
    public void laskePisteetEiHyvaksyVaaraaIndeksia() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);

        assertEquals(l.laskePisteet(20), -1);
    }
    
    @Test
    public void numero1() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 1, 1, 2, 3);

        assertEquals(l.numero(0), 3);
    }
    
    @Test
    public void numero2() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 1, 2, 2, 3);

        assertEquals(l.numero(1), 4);
    }
    
    @Test
    public void numero3() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 1, 1, 2, 3);

        assertEquals(l.numero(2), 3);
    }
    
    @Test
    public void numero4() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 4, 4, 4, 3);

        assertEquals(l.numero(3), 12);
    }
    
    @Test
    public void numero5() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(5, 1, 1, 2, 3);

        assertEquals(l.numero(4), 5);
    }
    
    @Test
    public void numero6() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 1, 6, 6, 6);

        assertEquals(l.numero(5), 18);
    }
    
    @Test
    public void numeroPalauttaaNollaJosEiYhtaan() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 3, 4, 4);

        assertEquals(l.montaSamaa(5), 0);
    }
    
    @Test
    public void montaSamaa2() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 3, 4, 4);

        assertEquals(l.montaSamaa(2), 8);
    }
    
    @Test
    public void montaSamaa2ValitseeParemmanKunKaksiParia() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 1, 3, 4, 4);

        assertEquals(l.montaSamaa(2), 8);
    }
    
    @Test
    public void montaSamaa3() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 4, 4, 4);

        assertEquals(l.montaSamaa(3), 12);
    }
    
    @Test
    public void montaSamaa4() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 2, 2, 2);

        assertEquals(l.montaSamaa(4), 8);
    }
    
    @Test
    public void montaSamaaPalauttaa0JosEiTulosta() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 3, 5, 2, 2);

        assertEquals(l.montaSamaa(3), 0);
    }
    
    @Test
    public void kaksiPariaToimii() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 1, 5, 2, 2);

        assertEquals(l.kaksiParia(), 6);
    }
    
    @Test
    public void kaksiPariaToimiiKunEiTulosta() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 3, 5, 2, 2);

        assertEquals(l.kaksiParia(), 0);
    }
    
    @Test
    public void kaksiPariaToimiiKunNeljaSamaa() {
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 2, 2, 2);

        assertEquals(l.kaksiParia(), 0);
    }
    
    @Test
    public void pikkuSuoraToimii() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 3, 4, 5);

        assertEquals(l.pikkuSuora(), 15);
    }
    
    @Test
    public void pikkuSuoraToimiiJosEiTulosta() {       
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 3, 4, 6);

        assertEquals(l.pikkuSuora(), 0);
    }
    
    @Test
    public void isoSuoraToimii() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(2, 3, 4, 5, 6);

        assertEquals(l.isoSuora(), 20);
    }
    
    @Test
    public void isoSuoraToimiiJosEiTulosta() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 3, 4, 6);

        assertEquals(l.isoSuora(), 0);
    }
    
    @Test
    public void tayskasiToimii() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 1, 3, 3, 1);

        assertEquals(l.tayskasi(), 9);
    }
    
    @Test
    public void tayskasiToimiiJosEiTulosta() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 2, 4, 1);

        assertEquals(l.tayskasi(), 0);
    }
    
    @Test
    public void sattumaToimii() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 5, 4, 5);

        assertEquals(l.sattuma(), 17);
    }
    
    @Test
    public void yatzyToimii() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 1, 1, 1, 1);

        assertEquals(l.yatzy(), 50);
    }
    
    @Test
    public void yatzyToimiiJosEiTulosta() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        k.setNopat(1, 2, 3, 4, 6);

        assertEquals(l.yatzy(), 0);
    }
    
    @Test
    public void valisummaToimii() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);       
        k.setNopat(1, 2, 5, 4, 5);
        l.laskeSarakkeenPisteet(4);
        
        assertEquals(l.valisumma(), 10);
    }
    
    @Test
    public void valisummaToimiiKunEiArvoja() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        
        assertEquals(l.valisumma(), 0);
    }
    
    @Test
    public void summaToimiiKunValisummaNolla() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);       
        k.setNopat(1, 2, 3, 4, 5);
        l.laskeSarakkeenPisteet(11);
        
        assertEquals(l.summa(), 15);
    }
    
    @Test
    public void summaToimiiKunLoppuosaNolla() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);       
        k.setNopat(1, 2, 3, 5, 5);
        l.laskeSarakkeenPisteet(4);
        
        assertEquals(l.summa(), 10);
    }
    
    @Test
    public void summaToimiiKunSekaNumeroitaEttaMuita() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);       
        k.setNopat(1, 2, 3, 4, 5);
        l.laskeSarakkeenPisteet(11);
        l.laskeSarakkeenPisteet(1);
        
        assertEquals(l.summa(), 17);
    }
    
    @Test
    public void summaToimiiKunEiArvoja() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        
        assertEquals(l.valisumma(), 0);
    }
    
    @Test
    public void osaSummaToimiiKunEiArvoja() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);
        
        assertEquals(l.osaSumma(0, 4), 0);
    }
    
    @Test
    public void osaSummaToimiiKunYksiArvo() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);    
        k.setNopat(2, 3, 4, 5, 6);
        l.laskeSarakkeenPisteet(12);
        
        assertEquals(l.osaSumma(7, 15), 20);
    }
    
    @Test
    public void osaSummaToimiiKunMontaArvoa() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);    
        k.setNopat(2, 3, 4, 5, 6);
        l.laskeSarakkeenPisteet(2);
        l.laskeSarakkeenPisteet(3);
        
        assertEquals(l.osaSumma(0, 4), 7);
    }
    
    @Test
    public void osaSummaPysyyAnnetussaValissa() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);    
        k.setNopat(2, 3, 4, 5, 6);
        l.laskeSarakkeenPisteet(2);
        l.laskeSarakkeenPisteet(3);
        
        assertEquals(l.osaSumma(3, 5), 4);
    }
    
    @Test
    public void jarjestaSilmaluvutToimii() {        
        Kasi k = new Kasi();
        Laskuri l = new Laskuri(k);    
        k.setNopat(2, 2, 4, 4, 4);
        int[] jarj = l.jarjestaSilmaluvut();
        boolean toimii = true;
        
        if (jarj[0] != 0 || jarj[1] != 2 || jarj[2] != 0 || jarj[3] != 3 || jarj[4] != 0 || jarj[5] != 0) {
            toimii = false;
        }
        
        assertTrue(toimii);
    }
}
