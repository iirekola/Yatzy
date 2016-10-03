package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import yatzy.Pelilogiikka;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Pelilogiikka logiikka = new Pelilogiikka(this);

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Yatzy");
        frame.setPreferredSize(new Dimension(1000, 800));
        frame.setIconImage(new ImageIcon("src/pikkunoppa.png").getImage());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
        
//        logiikka.aloitaPeli();
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        JPanel ohjeet = luoOhjeboksi();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        container.add(ohjeet, c);

        JPanel nopat = luoNopat();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        container.add(nopat, c);

//        JPanel nopat = luoNopat();
////        c.fill = GridBagConstraints.BOTH;
//        c.gridx = 0;
//        c.gridy = 1;
//        c.gridheight = 1;     
//        container.add(nopat, c);
        JPanel taulukko = luoTulostaulukko();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 4;
        container.add(taulukko, c);
    }

    public JFrame getFrame() {
        return frame;
    }

    private JPanel luoOhjeboksi() {
        JPanel p = new JPanel(new GridLayout(3,2));
        JLabel label = new JLabel("Tervetuloa pelaamaan Yatzya!");
        label.setFont(new Font("Serif", Font.PLAIN, 22));
        p.add(label);
        
        JButton heita = new JButton("Heitä nopat");
        heita.setFont(new Font("Serif", Font.PLAIN, 22));
        p.add(heita);
        
        p.add(new JLabel());
                
        return p;
    }

    private JPanel luoNopat() {
        JPanel p = new JPanel(new GridLayout(1, 7));
        p.add(new JLabel());
        p.add(new JToggleButton(new ImageIcon("src/pikkunoppa.png")));
        p.add(new JToggleButton(new ImageIcon("src/pikkunoppa.png")));
        p.add(new JToggleButton(new ImageIcon("src/pikkunoppa.png")));
        p.add(new JToggleButton(new ImageIcon("src/pikkunoppa.png")));
        p.add(new JToggleButton(new ImageIcon("src/pikkunoppa.png")));
        p.add(new JLabel());

        return p;
    }

    private JPanel luoTulostaulukko() {
        JPanel p = new JPanel(new GridLayout(18, 2));

        ArrayList<JLabel> otsikot = new ArrayList<>();

        JLabel yatzy = new JLabel("YATZY");
        yatzy.setFont(new Font("Serif", Font.BOLD, 16));
        p.add(yatzy);
        
        JLabel pelaaja  = new JLabel("Pisteet");
        pelaaja.setFont(new Font("Serif", Font.BOLD, 16));
        p.add(pelaaja);
        
        otsikot.add(new JLabel("Ykköset"));
        otsikot.add(new JLabel("Kakkoset"));
        otsikot.add(new JLabel("Kolmoset"));
        otsikot.add(new JLabel("Neloset"));
        otsikot.add(new JLabel("Viitoset"));
        otsikot.add(new JLabel("Kuutoset"));
        otsikot.add(new JLabel("VÄLISUMMA"));
        otsikot.add(new JLabel("Pari"));
        otsikot.add(new JLabel("Kaksi paria"));
        otsikot.add(new JLabel("Kolme samaa"));
        otsikot.add(new JLabel("Neljä samaa"));
        otsikot.add(new JLabel("Pikku suora"));
        otsikot.add(new JLabel("Iso suora"));
        otsikot.add(new JLabel("Täyskäsi"));
        otsikot.add(new JLabel("Sattuma"));
        otsikot.add(new JLabel("Yatzy"));
        otsikot.add(new JLabel("SUMMA"));

        for (JLabel label : otsikot) {
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setFont(new Font("Serif", Font.PLAIN, 16));
            p.add(label);
            p.add(new JToggleButton());
        }

        return p;
    }

}
