package yatzy;

/**
 * Käsi koostuu viidestä nopasta ja tarjoaa metodit noppien käsittelyyn. Käsi tallentaa noppien kulloisenkin tilan.
 */
import java.util.ArrayList;

public class Kasi {

    private Noppa[] nopat;

    /**
     * Konstruktori luo taulukon, jossa on paikat viidelle noppaoliolle. 
     *
     * @see yatzy.Kasi#luoNopat()
     */
    public Kasi() {
        this.nopat = new Noppa[5];
        luoNopat();
    }

    /**
     * luoNopat() luo kädelle viisi Noppa-oliota.
     *
     * @see yatzy.Noppa
     */
    private void luoNopat() {
        for (int i = 0; i < 5; i++) {
            nopat[i] = new Noppa();
        }
    }

    /**
     * getNopat() palauttaa kädessä olevat Nopat.
     * 
     * @return viiden kokoinen Noppa[]-taulukko
     */
    public Noppa[] getNopat() {
        return this.nopat;
    }

    /**
     * heitaNoppa(Noppa n) kutsuu nopan n metodia heitaNoppaa.
     * 
     * @param n Noppa-olio, jonka arvo halutaan arpoa uudelleen.
     */
    public void heitaNoppa(Noppa n) {
        n.heitaNoppaa();
    }

    /**
     * heitaValitutNopat() heittaa nopat, jotka ovat valittuina.
     * 
     * @see yatzy.Noppa#getValittu() 
     * @see yatzy.Kasi#heitaNoppa(yatzy.Noppa)
     */
    public void heitaValitutNopat() {
        for (Noppa noppa : nopat) {
            if (noppa.getValittu()) {
                heitaNoppa(noppa);
            }
        }
    }

    /**
     * heitaKaikkiNopat() heittää kaikki käden nopat.
     * 
     * @see yatzy.Kasi#heitaNoppa(yatzy.Noppa)
     */
    public void heitaKaikkiNopat() {
        for (Noppa noppa : nopat) {
            heitaNoppa(noppa);
        }
    }

    /**
     * valitseNoppa(int i) valitsee nopan taulukon indeksistä i.
     * 
     * @param i valittavan nopan indeksi taulukossa
     * @see yatzy.Noppa#setValittu(boolean) 
     */
    public void valitseNoppa(int i) {
        this.nopat[i].setValittu(true);
    }

    /**
     * vapautaNoppa(int i) vapauttaa nopan taulukon indeksistä i.
     * 
     * @param i vapautettavan nopan indeksi taulukossa
     * @see yatzy.Noppa#setValittu(boolean) 
     */
    public void vapautaNoppa(int i) {
        this.nopat[i].setValittu(false);
    }

    /**
     * vapautaKaikkiNopat() vapauttaa kaikki kädessä olevat nopat.
     * 
     * @see yatzy.Noppa#setValittu(boolean) 
     */
    public void vapautaKaikkiNopat() {
        for (Noppa noppa : nopat) {
            noppa.setValittu(false);

        }
    }

    /**
     * getSilmaluvut() palauttaa käden noppien tämänhetkiset silmäluvut int[] -taulukkona.
     * 
     * @return viiden kokoinen int[]-taulukko, jossa noppien silmäluvut
     * @see yatzy.Noppa#getArvo() 
     */
    public int[] getSilmaluvut() {
        int[] arvot = new int[5];
        for (int i = 0; i < 5; i++) {
            arvot[i] = this.nopat[i].getArvo();
        }

        return arvot;
    }

}
