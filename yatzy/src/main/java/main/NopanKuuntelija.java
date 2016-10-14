
package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import yatzy.Pelilogiikka;

/**
 *
 * @author iiris
 */
public class NopanKuuntelija implements ActionListener {
    private ArrayList<JToggleButton> nopat = new ArrayList<>();
    private Pelilogiikka logiikka;
    
    public NopanKuuntelija(Pelilogiikka l, ArrayList<JToggleButton> nopat) {
        this.logiikka = l;
        this.nopat = nopat;
    }

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