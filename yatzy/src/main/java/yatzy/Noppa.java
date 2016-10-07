package yatzy;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JToggleButton;

/**
 * Noppaa simuloiva luokka
 */
public class Noppa {

    private int arvo;
    private Random arpoja = new Random();
    private boolean valittu;

    public Noppa() {
        this.arvo = uusiArvo();
        this.valittu = false;
    }

    public int getArvo() {
        return this.arvo;
    }
    
    public void setValittu(boolean b) {
        this.valittu = b;
    }
    
    public boolean getValittu() {
        return this.valittu;
    }

    public int heitaNoppaa() {
        this.arvo = uusiArvo();
        return this.arvo;
    }

    public int uusiArvo() {
        return arpoja.nextInt(6) +1;
    }
    
    @Override
    public String toString() {
        return "" + this.arvo;
    }

}
