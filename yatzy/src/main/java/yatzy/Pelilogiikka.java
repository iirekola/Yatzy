package yatzy;

import java.util.ArrayList;
import java.util.Scanner;

public class Pelilogiikka {

    private ArrayList<Pelaaja> pelaajat;
    private Kasi kasi;
    private Scanner lukija = new Scanner(System.in);

    public Pelilogiikka() {
        this.pelaajat = new ArrayList<Pelaaja>();
        this.kasi = luoKasi();
    }                                                       //  Rivi 54, heitÃ¤ nopat tehty. Seuraavaksi valitse uudelleenheitettÃ¤v Ã¤t

    public void aloitaPeli() {
        alustaPeli();
        pelaa();
//        paataKierros();
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
    
    private Kasi luoKasi() {
        return new Kasi(luoNoppa(), 5);
    }
    
    private Noppa luoNoppa() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        
        return new Noppa(a);
    }
    
    private void pelaaVuoro(Pelaaja pelaaja) {
        heitaNopat();
        System.out.println(this.kasi.tulostaKasi());
    }
    
    private void heitaNopat() {
        this.kasi.heitaKaikkiNopat();
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
                System.out.println("Anna pelaajien mÃ¤Ã¤rÃ¤ numerona");
                continue;
            }

            if (montako > 0) {
                break;
            }
            System.out.println("Pelaajia tulee olla yksi tai enemmÃ¤n...");
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
