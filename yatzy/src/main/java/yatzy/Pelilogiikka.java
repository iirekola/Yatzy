
package yatzy;

import java.util.ArrayList;

public class Pelilogiikka {
    ArrayList<Pelaaja> pelaajat;
    
    public Pelilogiikka() {
    }
    
    
    public void aloitaPeli(int montakoPelaajaa) {
        luoPelaajat(montakoPelaajaa);
    }
    
    public void luoPelaajat(int montako) {
        for (int i = 0; i < montako; i++) {
            pelaajat.add(new Pelaaja(Integer.toString(i)));
        }
    }
    
    public void nimeaPelaaja(int monesko, String nimi) {
        this.pelaajat.get(monesko).setNimi(nimi);
    }
}