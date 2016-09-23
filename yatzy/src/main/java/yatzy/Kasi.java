package yatzy;

import java.util.ArrayList;

public class Kasi {
    private int[] nopat;
    private Noppa noppa;

    public Kasi(Noppa noppa, int montakoNoppaa) {
        this.noppa = noppa;
        this.nopat = new int[montakoNoppaa];
        alustaTaulukko(montakoNoppaa);
    }

    private void alustaTaulukko(int koko) {
        for (int i = 0; i < koko; i++) {
            this.nopat[i] = noppa.heitaNoppaa();
        }
    }
    
    public int[] getNopat() {
        return this.nopat;
    }
    
    public int[] heitaKaikkiNopat() {
        int[] silmaluvut = new int[nopat.length];
        for (int i = 0; i < nopat.length; i++) {            
            silmaluvut[i] = heitaNoppa(i);
        }
        return silmaluvut;
    }
    
    public int heitaNoppa(int monesko) {
        int uusiArvo = this.noppa.heitaNoppaa();
        this.nopat[monesko] = uusiArvo;
        return uusiArvo;
    }

    public String tulostaKasi() {
        String palautus = "";
        for (int i = 0; i < nopat.length; i++) {
            palautus += nopat[i] + "\n";
        }
        return palautus;
    }
}
