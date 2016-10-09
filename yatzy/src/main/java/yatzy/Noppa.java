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
     * setValittu(boolean b) asettaa nopan valituksi tai ei-valituksi. True valitsee nopan. False vapauttaa nopan.
     * 
     * @param b true = valitse noppa, false = vapauta noppa
     */
    public void setValittu(boolean b) {
        this.valittu = b;
    }

    /**
     * getValittu() kertoo onko noppa valittuna vai ei. True on valittu, False on ei-valittu.
     * 
     * @return onko noppa valittu
     */
    public boolean getValittu() {
        return this.valittu;
    }

    /**
     * heitaNoppaa() arpoo nopalle uuden arvon väliltä 1-6 ja tallentaa sen.
     * 
     * @return nopan uusi arvo
     */
    public int heitaNoppaa() {
        this.arvo = arpoja.nextInt(6) + 1;
        return this.arvo;
    }

    /**
     * toString() palauttaa nopan silmäluvun. Esim arvolla 3, toString() palauttaa "3".
     * 
     * @return nopan silmäluku
     */
    @Override
    public String toString() {
        return "" + this.arvo;
    }

}
