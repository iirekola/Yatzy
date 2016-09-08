
package yatzy;

import java.util.ArrayList;
import java.util.Random;

public class Arvojoukko {
    private ArrayList<Integer> arvot;
    private Random arpoja;
    
    public Arvojoukko(ArrayList<Integer> arvot) {
        this.arvot = arvot;
        this.arpoja = new Random();
    }
    
    public int getRandomArvo() {
        int paikka = this.arpoja.nextInt(arvot.size());
        return arvot.get(paikka);
    }
    
}
