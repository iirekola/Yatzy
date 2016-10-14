package main;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import yatzy.Pelilogiikka;

/**
 * Kayttoliittyma hoitaa graafisen käyttöliittymän komponenttien luomisen.
 * 
 * @see yatzy.Pelilogiikka
 * @author iiris
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Pelilogiikka logiikka = new Pelilogiikka();

    private ArrayList<JToggleButton> nopat;
    private ArrayList<JToggleButton> sarakkeet;
    private ArrayList<JLabel> pisteet;
    private JLabel label;

    /**
     * Konstruktori ei tee mitään erityistä.
     */
    public Kayttoliittyma() {
    }

    /**
     * Metodi luo graafisen käyttöliittymän ja sen komponentit.
     * 
     * @see main.Kayttoliittyma#luoKomponentit(java.awt.Container) 
     */
    @Override
    public void run() {
        frame = new JFrame("Yatzy");
        frame.setPreferredSize(new Dimension(1000, 800));
        frame.setIconImage(new ImageIcon("src/noppa5.png").getImage());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            luoKomponentit(frame.getContentPane());
        } catch (IOException ex) {
            Logger.getLogger(Kayttoliittyma.class.getName()).log(Level.SEVERE, null, ex);
        }

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Metodi asettaa layoutiksi gridBagLayoutin, johon tulee kolme JPanel komponenttia vertikaalisesti.
     * 
     * @param container 
     */
    private void luoKomponentit(Container container) throws IOException {
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

    /**
     * Metodi luo ensimmäisen kolmesta JPanel:sta. Ohjeboksi sisältää ohjeteksin ja napin noppien heittämiseen. Napille asetetetaan HeittonapinKuuntelija.
     * 
     * @return JPanel ohjeboksi
     */
    private JPanel luoOhjeboksi() {
        JPanel p = new JPanel(new GridLayout(3, 2));
        this.label = new JLabel("Tervetuloa pelaamaan Yatzya!");
        label.setFont(new Font("Serif", Font.PLAIN, 22));
        p.add(label);

        JButton heittaja = new JButton("Heitä nopat");
        heittaja.setFont(new Font("Serif", Font.PLAIN, 22));
        heittaja.addActionListener(new HeittonapinKuuntelija(this.logiikka, this, label));
        p.add(heittaja);

        p.add(new JLabel());

        return p;
    }

    /**
     * Metodi luo toisen kolmesta JPanel:sta. Metodi luo jokaiselle nopalle napin, jossa on nopan kuva. Napeille asetetaan NopanKuuntelija.
     * 
     * @return JPanel nopat
     */
    private JPanel luoNopat() throws IOException {
        JPanel p = new JPanel(new GridLayout(1, 7));
        this.nopat = new ArrayList<>();
        NopanKuuntelija nk = new NopanKuuntelija(this.logiikka, nopat);

        p.add(new JLabel());

        for (int i = 0; i < 5; i++) {
            JToggleButton noppa = new JToggleButton(new ImageIcon("src/noppa5.png"));
            noppa.addActionListener(nk);
            p.add(noppa);
            this.nopat.add(noppa);
        }

        p.add(new JLabel());

        return p;
    }

    /**
     * Metodi luo kolmannen kolmelta JPanel:sta. luoTulostaulukko luo jokaiselle sarakkeelle napin, jossa on sarakkeen nimi, sekä tyhjän JLabelin pisteiden kirjaamista varten. NApeille asetetaan SarakkeenKuuntelia.
     * 
     * @return JPanel taulukko
     */
    private JPanel luoTulostaulukko() {
        this.sarakkeet = new ArrayList<>();
        this.pisteet = new ArrayList<>();
       
        SarakkeenKuuntelija sk = new SarakkeenKuuntelija(this.logiikka, this, sarakkeet, pisteet);
        
        JPanel p = new JPanel(new GridLayout(18, 2));

        JLabel yatzy = new JLabel("YATZY");
        yatzy.setFont(new Font("Serif", Font.BOLD, 16));
        p.add(yatzy);

        JLabel pelaaja = new JLabel("Pisteet");
        pelaaja.setFont(new Font("Serif", Font.BOLD, 16));
        p.add(pelaaja);

        sarakkeet.add(new JToggleButton("Ykköset"));
        sarakkeet.add(new JToggleButton("Kakkoset"));
        sarakkeet.add(new JToggleButton("Kolmoset"));
        sarakkeet.add(new JToggleButton("Neloset"));
        sarakkeet.add(new JToggleButton("Viitoset"));
        sarakkeet.add(new JToggleButton("Kuutoset"));
        sarakkeet.add(new JToggleButton("VÄLISUMMA"));
        sarakkeet.add(new JToggleButton("Pari"));
        sarakkeet.add(new JToggleButton("Kaksi paria"));
        sarakkeet.add(new JToggleButton("Kolme samaa"));
        sarakkeet.add(new JToggleButton("Neljä samaa"));
        sarakkeet.add(new JToggleButton("Pikku suora"));
        sarakkeet.add(new JToggleButton("Iso suora"));
        sarakkeet.add(new JToggleButton("Täyskäsi"));
        sarakkeet.add(new JToggleButton("Sattuma"));
        sarakkeet.add(new JToggleButton("Yatzy"));
        sarakkeet.add(new JToggleButton("SUMMA"));

        for (JToggleButton nappi : sarakkeet) {
            nappi.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            nappi.setFont(new Font("Serif", Font.PLAIN, 16));
            nappi.addActionListener(sk);
            nappi.setEnabled(false);

            JLabel piste = new JLabel();
            piste.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            piste.setFont(new Font("Serif", Font.PLAIN, 16));
            pisteet.add(piste);

            p.add(nappi);
            p.add(piste);
        }

        return p;
    }

    /**
     * Päivittää noppanappeihin oikeaa silmälukua esittävät kuvat ja vapauttaa nopat.
     */
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

    /**
     * vapauttaa kaikki pistetaulukon napit.
     */
    public void vapautaTaulukko() {
        for (JToggleButton nappi : sarakkeet) {
            nappi.setEnabled(true);
        }
    }

    /**
     * lukitsee kaikki pistetaulukon napit.
     */
    public void lukitseTaulukko() {
        for (JToggleButton nappi : sarakkeet) {
            nappi.setEnabled(false);
        }
    }
    
    public void setLabel(String teksti) {
        this.label.setText(teksti);
    }

}
