package yatzy;

import java.util.ArrayList;
import java.util.Scanner;
import main.Kayttoliittyma;

public class Pelilogiikka {

    private Kasi kasi;
    private Laskuri laskuri;

    public Pelilogiikka() {
        this.kasi = new Kasi();
        this.laskuri = new Laskuri(this.kasi);
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
        return this.laskuri.laskeSarakkeenPisteet(sarake, this.kasi);
    }
    
    public Kasi getKasi() {
        return this.kasi;
    }
    
    public Laskuri getLaskuri() {
        return this.laskuri;
    }
}
