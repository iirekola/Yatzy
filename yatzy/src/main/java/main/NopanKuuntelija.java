
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import yatzy.Pelilogiikka;

/**
 *NopanKuuntelija reagoi kun jotakin nopista klikataan.
 * 
 * @author iiris
 */
public class NopanKuuntelija implements ActionListener {
    private ArrayList<JToggleButton> nopat = new ArrayList<>();
    private Pelilogiikka logiikka;
    
    /**
     * Konstruktori linkittää kuuntelijan pelilogiikkaan ja asettaa sille listan nopista.
     * 
     * @param l pelilogiikka
     * @param nopat lista noppanapeista
     */
    public NopanKuuntelija(Pelilogiikka l, ArrayList<JToggleButton> nopat) {
        this.logiikka = l;
        this.nopat = nopat;
    }

    /**
     * Metodi selvittää mistä nopasta on kyse. Noppa asetaan valituksi tai vapaaksi, riippuen sen lähtötilasta.
     * 
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JToggleButton button = (JToggleButton) e.getSource();
        
        for (int i = 0; i < 5; i++) {
            if (this.nopat.get(i).equals(button)) {
                this.logiikka.valitseNoppa(i);
            }
        }
    }    
}