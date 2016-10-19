package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import yatzy.Pelilogiikka;

/**
 * SarakkeenKuuntelija reagoi taulukon sarakkeen klikkauksiin.
 * 
 * @author iiris
 */
public class SarakkeenKuuntelija implements ActionListener {
    private Pelilogiikka logiikka;
    private ArrayList<JToggleButton> sarakkeet;
    private ArrayList<JLabel> pisteet;
    private Kayttoliittyma k;
    
    /**
     * Konstruktori linkkaa kuuntelijan pelilogiikkaan ja käyttöliittymään sekä käyttöliittymän sarake- ja pistelistoihin.
     * @param l pelilogiikka
     * @param k käyttöliittymä
     * @param sarakkeet lista sarakenappuloista
     * @param pisteet lista JLabeleita, joihin pisteen kirjataan
     */
    public SarakkeenKuuntelija(Pelilogiikka l, Kayttoliittyma k, ArrayList<JToggleButton> sarakkeet, ArrayList<JLabel> pisteet) {
        this.logiikka = l;
        this.pisteet = pisteet;
        this.sarakkeet = sarakkeet;
        this.k = k;
    }

    /**
     * Metodi reagoi sarakkeen klikkaukseen. Se selvittää mitä saraketta klikattiin, pyytää logiikkaa laskemaan pisteet ja kirjoittaa pisteet nappulaa vastaavaan JLabeliin.
     * Lopuksi metodi päivittää välisumman ja summan, lukitsee taulukon ja muuttaa ohjekentän tekstin.
     * 
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton button = (JToggleButton) e.getSource();
        
        int sarake = selvitaSarake(button);
        int pointsit = this.logiikka.laskeSarakkeenPisteet(sarake);
        
        if (pointsit == -1) {
            return;
        }
        
        this.pisteet.get(sarake).setText(String.valueOf(pointsit));

        paivitaSummaJaValisumma();
        k.lukitseTaulukko();
        k.setLabel("Aloita seuraava kierros");
    }
    
    /**
     * Metodi selvittää ja palauttaa painetun napin indeksin listassa.
     * 
     * @param button painettu nappi
     * @return napin indeksi listassa
     */
    public int selvitaSarake(JToggleButton button) {
        for (int i = 0; i < this.sarakkeet.size(); i++) {
            if (this.sarakkeet.get(i).equals(button)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Hakee taulukkoon pelilogiikasta nykyisen summan ja välisumman.
     */
    public void paivitaSummaJaValisumma() {
        int valisumma = this.logiikka.getValisumma();
        int summa = this.logiikka.getSumma();
        
        this.pisteet.get(6).setText(String.valueOf(valisumma));
        this.pisteet.get(16).setText(String.valueOf(summa));
    }
}
    