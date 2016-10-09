package yatzy;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JToggleButton;

/**
 * Noppaa simuloiva luokka. Noppa muistaa tämänhetkisen arvonsa ja onko se valittu vai ei. Noppaa hittämällä se arpoo itsellen uuden arvon väliltä 1-6.
 */
public class Noppa {

    private int arvo;
    private Random arpoja = new Random();
    private boolean valittu;

    /**
     * Konstruktori luo uuden Noppa-olion ja arpoo sille alkuarvon. Noppa asetetaan ei-valituksi.
     * 
     * @see yatzy.Noppa#heitaNoppaa() 
     */
    public Noppa() {
        heitaNoppaa();
        this.valittu = false;
    }

    /**
     * getArvo() palauttaa nopan tämänhetkisen silmäluvun.
     * 
     * @return nopan tämänhetkinen silmäluku
     */
    public int getArvo() {
        return this.arvo;
    }

    /**
     * setValittu(boolean b )
     * 
     * @param b 
     */
    public void setValittu(boolean b) {
        this.valittu = b;
    }

    public boolean getValittu() {
        return this.valittu;
    }

    public int heitaNoppaa() {
        this.arvo = arpoja.nextInt(6) + 1;
        return this.arvo;
    }

    @Override
    public String toString() {
        return "" + this.arvo;
    }

}
