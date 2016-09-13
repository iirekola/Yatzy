
package yatzy;

import java.util.ArrayList;
import java.util.Random;

/**
 * Noppaa simuloiva luokka
 */

public class Noppa {
    private ArrayList<Integer> arvot;
    private int arvo;
    private boolean lukittu;
    private Random arpoja =new Random();
    
    
    public Noppa(ArrayList<Integer> arvojoukko) {
        this.arvot = arvojoukko;
        this.arvo = uusiArvo();
        this.lukittu = false;
    }
    
    public int getArvo() {
        return this.arvo;
    }
    
    public ArrayList<Integer> getArvot() {
        return this.arvot;
    }
    
    public void heitaNoppaa() {
        this.arvo = uusiArvo();
    }
    
    public int uusiArvo() {
        return arvot.get(arpoja.nextInt(arvot.size()));
    }
    
    public void lukitse() {
        this.lukittu = true;
    }
    
    public void vapauta() {
        this.lukittu = false;
    }
    
    public boolean onkoLukittu() {
        return this.lukittu;
    }
}
