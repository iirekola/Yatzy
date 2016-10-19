package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import yatzy.Pelilogiikka;

/**
 * HeittonapinKuuntelija reagoi heittonapin klikkauksiin.
 * 
 * @author iiris
 */
public class HeittonapinKuuntelija implements ActionListener {

    private Pelilogiikka logiikka;
    private Kayttoliittyma k;
    private int mikaVuoro;
    private JLabel ohjeet;

    /**
     * Konstruktori linkittää kuuntelijan pelilogiikkaan, käyttöliittymään ja JLabeliin johon ohjeistus päivitetään, sekä asettaa vuorolaskurin aloitusarvoonsa.
     * 
     * @param l pelilogiikka
     * @param k käyttöliittymä
     * @param ohjeet JLabel, jossa on vaihtuva ohjeteksti
     */
    public HeittonapinKuuntelija(Pelilogiikka l, Kayttoliittyma k, JLabel ohjeet) {
        this.logiikka = l;
        this.k = k;
        this.mikaVuoro = 0;
        this.ohjeet = ohjeet;
    }

    /**
     * Metodi taristaa mikä pelin vaihe on käynnissä ja heittää asiaankuuluvat nopat, päivittää ohjeet ja kasvattaa vuorolaskurin arvoa.
     * 
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (this.ohjeet.getText().equals("Aloita seuraava kierros")) {
            this.mikaVuoro = 0;
        }
        if (this.mikaVuoro == 0) {
            logiikka.heitaKaikkiNopat();
            paivita("Valitse nopat, jotka haluat heittää uudestaan. (1. Kerta)");
        } else if (this.mikaVuoro == 1) {
            logiikka.heitaValitutNopat();
            paivita("Valitse nopat, jotka haluat heittää uudestaan. (2. Kerta)");           
        } else if (this.mikaVuoro == 2) {
            logiikka.heitaValitutNopat();
            paivita("Kirjaa tulos");
            k.vapautaTaulukko();
        }
    }

    /**
     * Metodi päivittää noppien kuvat, muuttaa ohjetekstin ja kasvattaa vuoroa. 
     * 
     * @param labelTeksti uusi ohjeteksti
     */
    public void paivita(String labelTeksti) {
        k.paivitaNopat();
        this.ohjeet.setText(labelTeksti);
        this.mikaVuoro++;
    } 
}
