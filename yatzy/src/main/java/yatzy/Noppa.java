package yatzy;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JToggleButton;

/**
 * Noppaa simuloiva luokka.
 */
public class Noppa {

    private int arvo;
    private Random arpoja = new Random();
    private boolean valittu;

    public Noppa() {
        heitaNoppaa();
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
        this.arvo = arpoja.nextInt(6) + 1;
        return this.arvo;
    }

    @Override
    public String toString() {
        return "" + this.arvo;
    }

}
