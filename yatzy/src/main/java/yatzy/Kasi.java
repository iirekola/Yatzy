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
    
    public void heitaKaikkiNopat() {
        for (int i = 0; i < nopat.length; i++) {
            heitaNoppa(i);
        }
    }
    
    public void heitaNoppa(int monesko) {
        int uusiArvo = this.noppa.heitaNoppaa();
        this.nopat[monesko] = uusiArvo;
    }

    public String tulostaKasi() {
        String palautus = "";
        for (int i = 0; i < nopat.length; i++) {
            palautus += nopat[i] + "\n";
        }
        return palautus;
    }

}
