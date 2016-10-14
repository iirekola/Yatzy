package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import yatzy.Pelilogiikka;

/**
 *
 * @author iiris
 */
public class HeittonapinKuuntelija implements ActionListener {

    private Pelilogiikka logiikka;
    private Kayttoliittyma k;
    private int mikaVuoro;
    private JLabel ohjeet;

    public HeittonapinKuuntelija(Pelilogiikka l, Kayttoliittyma k, JLabel ohjeet) {
        this.logiikka = l;
        this.k = k;
        this.mikaVuoro = 0;
        this.ohjeet = ohjeet;
    }

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

    public void paivita(String labelTeksti) {
        k.paivitaNopat();
        this.ohjeet.setText(labelTeksti);
        this.mikaVuoro++;
    } 
}
