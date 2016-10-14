
package yatzy;

/**
 * Taulukkoon tallennetaan pisteet sitä mukaa kun sarakkeita valitaan. Tyhjän sarakkeen arvo on -1. Sarake 6 on välisumma ja sarake 16 on summa.
 *
 * @author iiris
 */
public class Taulukko {
    private int[] pisteet;
    
    /**
     * Konstruktori luo taulukon ja alustaa kaikkiin indekseihin arvon -1.
     * 
     * @see yatzy.Taulukko#alustaPisteet()
     */
    public Taulukko() {
        this.pisteet = new int[17];
        alustaPisteet();
    }
    
    /**
     * Palauttaa pistetaulukon.
     * 
     * @return pisteet
     */
    public int[] getPisteet() {
        return this.pisteet;
    }

    /**
     * alustaPisteet() asettaa kaikkiin taulukon indekseihin arvon -1.
     */
    public void alustaPisteet() {
        for (int i = 0; i < 17; i++) {
            this.pisteet[i] = -1;
        }
    }
    
    /**
     * Palauttaa parametrinä olevan sarakkeen pisteet.
     * 
     * @param sarake sarake jonka pisteet palautetaan
     * @return sarakkeen pisteet
     */
    public int getSarake(int sarake) {
        return this.pisteet[sarake]; 
    }
    
    /**
     * Asettaa ensimmäisenä parametrinä olevaan sarakkeeseen toisena parametrinä olevan pistemäärän.
     * 
     * @param sarake sarake, johon pisteet tallennetaan
     * @param pisteet pistemäärä, joka sarakkeeseen tallennetaan
     */
    public void setSarake(int sarake, int pisteet) {
        this.pisteet[sarake] = pisteet;
    }
    
//    Taulukon sisältö:
//    0 Ykköset
//    1 Kakkoset
//    2 Kolmoset
//    3 Neloset
//    4 Viitoset
//    5 Kuutoset
//    6 VÄLISUMMA
//    7 Pari
//    8 Kaksi paria
//    9 Kolme samaa
//    10 Neljä samaa
//    11 Pikku suora
//    12 Iso suora
//    13 Täyskäsi
//    14 Sattuma
//    15 Yatzy
//    16 SUMMA
}
