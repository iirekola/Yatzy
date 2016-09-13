package yatzy;

import java.util.ArrayList;

public class Kasi {

    private int[] maarat;
    ArrayList<Noppa> nopat;
    

    public Kasi(ArrayList<Noppa> nopat) {
        this.nopat = nopat;
        int arvojenMaara = nopat.get(0).getArvot().size();
        this.maarat = new int[arvojenMaara];
        alustaTaulukko(arvojenMaara);
    }
    
    private void alustaTaulukko(int koko) {
        for (int i = 0; i < koko; i++) {
            this.maarat[i] = 0;
        }
    }

}
