
package yatzy;

/**
 * Noppaa simuloiva luokka
 */

public class Noppa {
    private Arvojoukko arvot;
    private int arvo;
    
    
    public Noppa(Arvojoukko arvojoukko) {
        this.arvot = arvojoukko;
        this.arvo = uusiArvo();
    }
    
    public int getArvo() {
        return this.arvo;
    }
    
    public void heitaNoppaa() {
        this.arvo = uusiArvo();
    }
    
    private int uusiArvo() {
        return arvot.getRandomArvo();
    }
}
