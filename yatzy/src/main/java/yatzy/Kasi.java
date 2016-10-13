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
     * Asettaa nopille parametreinä olevat silmäluvut. Metodi on testausta varten.
     * 
     * @param n1 noppaan 1 asetettava arvo
     * @param n2 noppaan 2 asetettava arvo
     * @param n3 noppaan 3 asetettava arvo
     * @param n4 noppaan 4 asetettava arvo
     * @param n5 noppaan 5 asetettava arvo
     */
    public void setNopat(int n1, int n2, int n3, int n4, int n5) {
        this.nopat[0].setArvo(n1);
        this.nopat[1].setArvo(n2);
        this.nopat[2].setArvo(n3);
        this.nopat[3].setArvo(n4);
        this.nopat[4].setArvo(n5);
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
     * valitseNoppa(int i) valitsee tai vapauttaa nopan taulukon indeksistä i.
     * 
     * @param i valittavan nopan indeksi taulukossa
     * @param b false vapauttaa nopan, true valitsee nopan
     * @see yatzy.Noppa#setValittu(boolean) 
     */
    public void valitseNoppa(int i, boolean b) {
        this.nopat[i].setValittu(b);
    }
    
    /**
     * onkoValittu(int i) kertoo onko käden indeksissä i oleva noppa valittuna vai ei.
     * 
     * @param i nopan indeksi taulukossa
     * @return false vapaalle, true valitulle nopalle
     */
    public boolean onkoValittu(int i) {
        return this.nopat[i].getValittu();
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
