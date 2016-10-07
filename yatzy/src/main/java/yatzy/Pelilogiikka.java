package yatzy;

import java.util.ArrayList;
import java.util.Scanner;
import main.Kayttoliittyma;

public class Pelilogiikka {

    private Pelaaja pelaaja;
    private Kasi kasi;
    private Kayttoliittyma k;
    private Laskuri laskuri;

    public Pelilogiikka(Kayttoliittyma k) {
        this.pelaaja = new Pelaaja();
        this.kasi = new Kasi();
        this.k = k;
        this.laskuri = new Laskuri();
    }

    public void heitaKaikkiNopat() {
        this.kasi.heitaKaikkiNopat();
        this.kasi.vapautaKaikkiNopat();
    }
    
    public void heitaValitutNopat() {
        this.kasi.heitaValitutNopat();
        this.kasi.vapautaKaikkiNopat();
    }
    
    public int[] getSilmaluvut() {
        return this.kasi.getSilmaluvut();
    }
    
    public void valitseNoppa(int monesko) {
        this.kasi.valitseNoppa(monesko);
    }
    
    public int laskeSarakkeenPisteet(String sarake) {
        return this.laskuri.laskeSarakkeenPisteet(sarake);
    }
}
