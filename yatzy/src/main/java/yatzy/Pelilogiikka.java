package yatzy;

import java.util.ArrayList;
import java.util.Scanner;

public class Pelilogiikka {

    private ArrayList<Pelaaja> pelaajat;
    private Scanner lukija = new Scanner(System.in);

    public Pelilogiikka() {
        this.pelaajat = new ArrayList<Pelaaja>();
    }

    public void aloitaPeli() {
        alustaPeli();
        pelaa();
    }

    private void alustaPeli() {
        int montakoPelaajaa = montakoPelaajaa();
        luoPelaajat(montakoPelaajaa);
        nimeaPelaajat();
    }
    
    private void pelaa() {
        while(!peliOnOhi()) {
            for (Pelaaja pelaaja : this.pelaajat) {
                pelaaVuoro(pelaaja);
            }
        }
    }
    
    private void pelaaVuoro(Pelaaja pelaaja) {
        
    }
    
    private boolean peliOnOhi(){
        for (Pelaaja pelaaja : this.pelaajat) {
            if (!pelaaja.getPisteet().onTaysi()){
                return false;
            }
        }
        return true;
    }

    private void nimeaPelaajat() {
        int i = 1;
        for (Pelaaja pelaaja : pelaajat) {
            System.out.println("Anna nimi pelaajalle " + i);
            pelaaja.setNimi(this.lukija.nextLine());
            i++;
        }
    }

    private int montakoPelaajaa() {
        int montako = 0;
        System.out.println("Tervetuloa pelaamaan Yatzya! Montako pelaajaa peliin osallistuu?");

        while (montako <= 0) {

            try {
                montako = Integer.parseInt(lukija.nextLine());
            } catch (Exception e) {
                System.out.println("Anna pelaajien määrä numerona");
                continue;
            }

            if (montako > 0) {
                break;
            }
            System.out.println("Pelaajia tulee olla yksi tai enemmän...");
        }
        return montako;
    }

    private void luoPelaajat(int montako) {
        for (int i = 0; i < montako; i++) {
            pelaajat.add(new Pelaaja(Integer.toString(i)));
        }
    }

    private void nimeaPelaaja(int monesko, String nimi) {
        this.pelaajat.get(monesko).setNimi(nimi);
    }
}
