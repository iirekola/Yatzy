package yatzy;

import java.util.ArrayList;
import java.util.Scanner;
import main.Kayttoliittyma;

/**
 * Pelilogiikka tarjoaa metodit, joiden avulla peli etenee.
 */
public class Pelilogiikka {

    private Kasi kasi;
    private Laskuri laskuri;

    /**
     * Konstruktori luo pelilogiikalle käden ja laskurin.
     */
    public Pelilogiikka() {
        this.kasi = new Kasi();
        this.laskuri = new Laskuri(this.kasi);
    }

    /**
     * heitaKaikkiNopat() heittää kaikki kädessä olevat nopat ja vapauttaa ne sen jälkeen.
     * 
     * @see yatzy.Kasi#heitaKaikkiNopat() 
     * @see yatzy.Kasi#vapautaKaikkiNopat() 
     */
    public void heitaKaikkiNopat() {
        this.kasi.heitaKaikkiNopat();
        this.kasi.vapautaKaikkiNopat();
    }
    
    /**
     * heitaValitutNopat() heittaa nopat, jotka ovat tilassa valittu ja vapauttaa sen jälkeen kaikki nopat.
     * 
     * @see yatzy.Kasi#heitaValitutNopat() 
     * @see yatzy.Kasi#vapautaKaikkiNopat() 
     */
    public void heitaValitutNopat() {
        this.kasi.heitaValitutNopat();
        this.kasi.vapautaKaikkiNopat();
    }
    
    /**
     * getSilmaluvut() palauttaa taulukon, johon on tallennettu noppien tämänhetkiset silmäluvut.
     * 
     * @return int[]-taulukko, johon on tallennettu noppien silmäluvut
     * @see yatzy.Kasi#getSilmaluvut() 
     */
    public int[] getSilmaluvut() {
        return this.kasi.getSilmaluvut();
    }
    
    /**
     * valitseNoppa(int monesko) tarkistaa onko annetussa indeksissä oleva noppa valittu vai ei.
     * Jos noppa on valittu, se vapautetaan. Jos noppa on vapaa, se valitaan.
     * 
     * @param monesko valittavan nopan indeksi taulukossa
     * @see yatzy.Kasi#valitseNoppa(int, boolean)  
     * @see yatzy.Kasi#onkoValittu(int) 
     */
    public void valitseNoppa(int monesko) {
        if (this.kasi.onkoValittu(monesko)) {
            this.kasi.valitseNoppa(monesko, false);
        } else {
            this.kasi.valitseNoppa(monesko, true);
        }
    }
    
    /**
     * laskeSarakkeenPisteet(String sarake) palauttaa pistemäärän, jonka käsi saa valitussa sarakkeessa.
     * 
     * @param sarake sarakkeen nimi
     * @return pistemäärä
     */
    public int laskeSarakkeenPisteet(int sarake) {
        return this.laskuri.laskeSarakkeenPisteet(sarake);
    }
    
    /**
     * Metodi palauttaa laskurin "SUMMA" sarakken arvon.
     * 
     * @return summa
     */
    public int getSumma() {
        return this.laskuri.getSumma();
    }
    
    /**
     * Metodi palauttaa laskurin "VÄLISUMMA" sarakkeen arvon.
     * 
     * @return välisumma
     */
    public int getValisumma() {
        return this.laskuri.getValisumma();
    }
    
    /**
     * palauttaa käden.
     * 
     * @return käsi
     */
    public Kasi getKasi() {
        return this.kasi;
    }
    
    /**
     * palauttaa laskurin.
     * 
     * @return laskuri
     */
    public Laskuri getLaskuri() {
        return this.laskuri;
    }
}
