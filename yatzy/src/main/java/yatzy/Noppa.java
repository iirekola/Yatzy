package yatzy;

import java.util.ArrayList;
import java.util.Random;

/**
 * Noppaa simuloiva luokka
 */
public class Noppa {

    private ArrayList<Integer> arvot;
    private int arvo;
    private Random arpoja = new Random();

    public Noppa(ArrayList<Integer> arvojoukko) {
        this.arvot = arvojoukko;
        this.arvo = uusiArvo();
    }

    public int getArvo() {
        return this.arvo;
    }

    public ArrayList<Integer> getArvot() {
        return this.arvot;
    }

    public int heitaNoppaa() {
        this.arvo = uusiArvo();
        return this.arvo;
    }

    public int uusiArvo() {
        return arvot.get(arpoja.nextInt(arvot.size()));
    }

}
