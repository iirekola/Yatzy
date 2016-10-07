package yatzy;

/* 
 * Käsi koostuu viidestä nopasta ja tarjoaa metodit noppien käsittelyyn.
 */
import java.util.ArrayList;

public class Kasi {

    private Noppa[] nopat;

    /* 
     * Konstruktori luo taulukon, jossa on paikat viidelle noppaoliolle. 
     *
     *
     * @see yatzy.Kasi#luoNopat()
     */
    public Kasi() {
        this.nopat = new Noppa[5];
        luoNopat();
    }

    private void luoNopat() {
        for (int i = 0; i < 5; i++) {
            nopat[i] = new Noppa();
        }
    }

    public Noppa[] getNopat() {
        return this.nopat;
    }

    public void heitaNoppa(Noppa n) {
        n.heitaNoppaa();
    }

    public void heitaValitutNopat() {
        for (Noppa noppa : nopat) {
            if (noppa.getValittu()) {
                heitaNoppa(noppa);
            }
        }
    }

    public void heitaKaikkiNopat() {
        for (Noppa noppa : nopat) {
            heitaNoppa(noppa);
        }
    }

    public void valitseNoppa(int i) {
        this.nopat[i].setValittu(true);
    }

    public void vapautaNoppa(int i) {
        this.nopat[i].setValittu(false);
    }

    public void vapautaKaikkiNopat() {
        for (Noppa noppa : nopat) {
            noppa.setValittu(false);

        }
    }

    public int[] getSilmaluvut() {
        int[] arvot = new int[5];
        for (int i = 0; i < 5; i++) {
            arvot[i] = this.nopat[i].getArvo();
        }

        return arvot;
    }

}
