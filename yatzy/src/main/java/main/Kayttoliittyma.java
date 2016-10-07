package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Kayttoliittyma implements Runnable, ActionListener {

    private JFrame frame;
    private Pelilogiikka logiikka = new Pelilogiikka(this);

    private JButton heittaja;
    private ArrayList<JToggleButton> nopat = new ArrayList<>();
    private ArrayList<JToggleButton> sarakkeet = new ArrayList<>();
    private ArrayList<JLabel> pisteet = new ArrayList<>();

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Yatzy");
        frame.setPreferredSize(new Dimension(1000, 800));
        frame.setIconImage(new ImageIcon("src/noppa5.png").getImage());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
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
        JPanel p = new JPanel(new GridLayout(3, 2));
        JLabel label = new JLabel("Tervetuloa pelaamaan Yatzya!");
        label.setFont(new Font("Serif", Font.PLAIN, 22));
        p.add(label);

        this.heittaja = new JButton("Heitä nopat");
        heittaja.setFont(new Font("Serif", Font.PLAIN, 22));
        heittaja.addActionListener(this);
        p.add(heittaja);

        p.add(new JLabel());

        return p;
    }

    private JPanel luoNopat() {
        JPanel p = new JPanel(new GridLayout(1, 7));

        p.add(new JLabel());

        for (int i = 0; i < 5; i++) {
            JToggleButton noppa = new JToggleButton(new ImageIcon("src/noppa5.png"));
            noppa.addActionListener(this);
            p.add(noppa);
            this.nopat.add(noppa);
        }

        p.add(new JLabel());

        return p;
    }

    private JPanel luoTulostaulukko() {
        JPanel p = new JPanel(new GridLayout(18, 2));

        JLabel yatzy = new JLabel("YATZY");
        yatzy.setFont(new Font("Serif", Font.BOLD, 16));
        p.add(yatzy);

        JLabel pelaaja = new JLabel("Pisteet");
        pelaaja.setFont(new Font("Serif", Font.BOLD, 16));
        p.add(pelaaja);

        this.sarakkeet.add(new JToggleButton("Ykköset"));
        this.sarakkeet.add(new JToggleButton("Kakkoset"));
        this.sarakkeet.add(new JToggleButton("Kolmoset"));
        this.sarakkeet.add(new JToggleButton("Neloset"));
        this.sarakkeet.add(new JToggleButton("Viitoset"));
        this.sarakkeet.add(new JToggleButton("Kuutoset"));
        this.sarakkeet.add(new JToggleButton("VÄLISUMMA"));
        this.sarakkeet.add(new JToggleButton("Pari"));
        this.sarakkeet.add(new JToggleButton("Kaksi paria"));
        this.sarakkeet.add(new JToggleButton("Kolme samaa"));
        this.sarakkeet.add(new JToggleButton("Neljä samaa"));
        this.sarakkeet.add(new JToggleButton("Pikku suora"));
        this.sarakkeet.add(new JToggleButton("Iso suora"));
        this.sarakkeet.add(new JToggleButton("Täyskäsi"));
        this.sarakkeet.add(new JToggleButton("Sattuma"));
        this.sarakkeet.add(new JToggleButton("Yatzy"));
        this.sarakkeet.add(new JToggleButton("SUMMA"));

        for (JToggleButton nappi : sarakkeet) {
            nappi.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            nappi.setFont(new Font("Serif", Font.PLAIN, 16));
            nappi.addActionListener(this);
            nappi.setEnabled(false);

            JLabel piste = new JLabel();
            piste.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            piste.setFont(new Font("Serif", Font.PLAIN, 16));
            this.pisteet.add(piste);

            p.add(nappi);
            p.add(piste);
        }
        

        return p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JToggleButton button = (JToggleButton) e.getSource();

            if (this.nopat.contains(button)) {
                reagoiNoppaan(button);
            }
            
            if (this.sarakkeet.contains(button)) {
                reagoiSarakkeeseen(button);
            }

        } catch (Exception exptn) {
            JButton button = (JButton) e.getSource();

            reagoiHeittonappiin(button);
        }
    }

    public void reagoiNoppaan(JToggleButton button) {
        for (int i = 0; i < 5; i++) {
            if (this.nopat.get(i).equals(button)) {
                this.logiikka.valitseNoppa(i);
            }
        }
    }
    
    public void reagoiSarakkeeseen(JToggleButton button) {
        if (button.getText().equals("VÄLISUMMA") || button.getText().equals("SUMMA")) {
            return;
        }
        
        JLabel sarake = selvitaSarake(button);
        
        int pisteet = this.logiikka.laskeSarakkeenPisteet(button.getText());
        sarake.setText(String.valueOf(pisteet));
        sarake.setEnabled(false);
        
        paivitaSummaJaValisumma();
        lukitseTaulukko();
        this.heittaja.setText("Heitä nopat");
    }
    
    public JLabel selvitaSarake(JToggleButton button) {
        for (int i = 0; i < this.sarakkeet.size(); i++) {
            if (this.sarakkeet.get(i).equals(button)) {
                return this.pisteet.get(i);
            }
        }
                
        return null;
    }
    
    public void paivitaSummaJaValisumma() {
        int valisumma = 0;
        int summa = 0;
        for (JLabel piste : this.pisteet) {
            if (!piste.getText().isEmpty()) {
                
            }
        }
    }

    public void reagoiHeittonappiin(JButton button) {
        if (button.getText() == "Heitä nopat") {
            heitaKaikkiNopat();
            paivitaNopat();
            button.setText("Heitä valitsemani nopat uudestaan (1. kerta)");
        } else if (button.getText() == "Heitä valitsemani nopat uudestaan (1. kerta)") {
            heitaValitutNopat();
            paivitaNopat();
            button.setText("Heitä valitsemani nopat uudestaan (2. kerta)");
        } else if (button.getText() == "Heitä valitsemani nopat uudestaan (2. kerta)") {
            heitaValitutNopat();
            paivitaNopat();
            button.setText("Kirjaa tulos");
            vapautaTaulukko();
        }
    }

    public void heitaValitutNopat() {
        this.logiikka.heitaValitutNopat();
    }

    public void heitaKaikkiNopat() {
        this.logiikka.heitaKaikkiNopat();
    }

    public void paivitaNopat() {
        int[] silmaluvut = this.logiikka.getSilmaluvut();
        for (int i = 0; i < 5; i++) {
            int silmaluku = silmaluvut[i];
            String kuvanOsoite = "src/noppa" + silmaluku + ".png";
            this.nopat.get(i).setIcon(new ImageIcon(kuvanOsoite));
        }

        for (JToggleButton noppa : nopat) {
            if (noppa.isSelected()) {
                noppa.setSelected(false);
            }
        }
    }
    
    public void vapautaTaulukko() {
        for (JToggleButton nappi : sarakkeet) {
            nappi.setEnabled(true);
        }
    }

    public void lukitseTaulukko() {
        for (JToggleButton nappi : sarakkeet) {
            nappi.setEnabled(false);
        }
    }

}
