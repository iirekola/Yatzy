package yatzy;

/**
 * Laskuri laskee mikä arvo valittuun sarakkeeeen tallennetaan.
 */
public class Laskuri {

    private Kasi kasi;
    private int[] pisteet;

    /**
     * Konstruktori asettaa laskurille Käsi-muuttujan ja luo taulukon pisteiden
     * tallentamiseen. Taulukko alustetaan niin, että kaikissa indekseissä on
     * -1.
     *
     * @param kasi käsi, josta laskuri hakee noppien tilan
     * @see yatzy.Laskuri#alustaPisteet()
     */
    public Laskuri(Kasi kasi) {
        this.kasi = kasi;
        this.pisteet = new int[17];
        alustaPisteet();
    }
    
    /**
     * Palauttaa käden.
     * 
     * @return käsi
     */
    public Kasi getKasi() {
        return this.kasi;
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
     * laskeSarakkeenPisteet(String sarake) tarkistaa voiko kyseiseen
     * sarakkeeseen tallentaa ja palauttaa -1 jos ei voi. Jos sarakkeeseen voi
     * tallentaa, metodi laskee pisteiden määrän ja tallentaa ja palauttaa sen,
     * sekä päivittää summan ja välisumman.
     *
     * @param sarake Sarakkeen nimi, johon tulos tallennetaan
     * @return sarakkeeseeen tallennettavat pisteet
     *
     * @see yatzy.Laskuri#laskePisteet(int)
     * @see yatzy.Laskuri#voiTallentaa(int)
     */
    public int laskeSarakkeenPisteet(int sarake) {
        if (voiTallentaa(sarake)) {
            int pointsit = laskePisteet(sarake);
            this.pisteet[sarake] = pointsit;

            this.pisteet[6] = valisumma();
            this.pisteet[16] = summa();

            return pointsit;
        }
        return -1;
    }

    /**
     * voiTallentaa(int sarake) palauttaa true jos sarakkeeseen voi tallentaa
     * pisteet. Metodi palautta false jos sarakkeessa on jo arvo tai kyseessä on
     * summa, välisumma tai testaukseen käytetty sarake.
     *
     * @param sarake sarakkeen indeksi taulukossa
     * @return voiko sarakkeeseen tallentaa arvon.
     */
    public boolean voiTallentaa(int sarake) {
        if (sarake == 6 || sarake == 16) {       // Välisumma, summa
            return false;
        }
        if (this.pisteet[sarake] == -1) {
            return true;
        }
        return false;
    }

    /**
     * laskePisteet(int sarake) selvittää mitä laskusääntöä tulee käytää ja
     * kutsuu asiaankuuluvaa metodia.
     *
     * @param s sarakkeen indeksi taulukossa
     * @return sarakkeeseeen tallennettavat pisteet
     */
    public int laskePisteet(int s) {
        if (s >= 0 && s <= 5) {
            return numero(s);
        }
        if (s == 7) {
            return montaSamaa(2);
        }
        if (s == 8) {
            return kaksiParia();
        }
        if (s == 9) {
            return montaSamaa(3);
        }
        if (s == 10) {
            return montaSamaa(4);
        }
        if (s == 11) {
            return pikkuSuora();
        }
        if (s == 12) {
            return isoSuora();
        }
        if (s == 13) {
            return tayskasi();
        }
        if (s == 14) {
            return sattuma();
        }
        if (s == 15) {
            return yatzy();
        }
        return -1;
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
    
    /**
     * Metodi laskee käden silmälukuja vastaavat pisteet sarakkeille ykkoset...kuutoset.
     * 
     * @param i haettu silmäluku
     * @return kättä vastaava pistemäärä
     */
    public int numero(int i) {
        int[] jarj = jarjestaSilmaluvut();
        return jarj[i] * (i + 1);
    }

    /**
     * Metodi laskee käden silmälukuja vastaavat pisteet sarakkeille kaksi, kolme ja neljä samaa.
     * 
     * @param m montako samaa
     * @return kättä vastaava pistemäärä
     */
    public int montaSamaa(int m) {
        int[] jarj = jarjestaSilmaluvut();
        for (int i = 6; i > 0; i--) {
            if (jarj[i - 1] >= m) {
                return m * i;
            }
        }
        return 0;
    }

    /**
     * Metodi laskee käden silmälukuja vastaavat pisteet sarakkeelle kaksi paria.
     * 
     * 
     * @return kättä vastaava pistemäärä
     */
    public int kaksiParia() {
        int[] jarj = jarjestaSilmaluvut();
        int summa = 0;
        int lkm = 0;

        for (int i = 6; i > 0; i--) {
            if (jarj[i - 1] >= 2) {
                summa += 2 * i;
                lkm++;
                if (lkm >= 2) {
                    return summa;
                }
            }
        }
        return 0;
    }

    /**
     * Metodi laskee käden silmälukuja vastaavat pisteet sarakkeelle pikku suora.
     * 
     * 
     * @return kättä vastaava pistemäärä
     */
    public int pikkuSuora() {
        int[] jarj = jarjestaSilmaluvut();
        for (int i = 0; i < 5; i++) {
            if (jarj[i] <= 0) {
                return 0;
            }
        }
        return 15;
    }

    /**
     * Metodi laskee käden silmälukuja vastaavat pisteet sarakkeelle iso suora.
     * 
     * 
     * @return kättä vastaava pistemäärä
     */
    public int isoSuora() {
        int[] jarj = jarjestaSilmaluvut();
        for (int i = 1; i < 6; i++) {
            if (jarj[i] <= 0) {
                return 0;
            }
        }
        return 20;
    }

    /**
     * Metodi laskee käden silmälukuja vastaavat pisteet sarakkeelle täyskäsi.
     * 
     * 
     * @return kättä vastaava pistemäärä
     */
    public int tayskasi() {
        int summa = 0;
        boolean kaksi = false;
        boolean kolme = false;

        int[] jarj = jarjestaSilmaluvut();
        for (int i = 0; i < 6; i++) {
            if (jarj[i] == 2) {
                summa += 2 * (i + 1);
                kaksi = true;
            }
            if (jarj[i] == 3) {
                summa += 3 * (i + 1);
                kolme = true;
            }
        }

        if (kaksi && kolme) {
            return summa;
        }
        return 0;
    }

    /**
     * Metodi laskee käden silmälukuja vastaavat pisteet sarakkeelle sattuma.
     * 
     * 
     * @return kättä vastaava pistemäärä
     */
    public int sattuma() {
        int summa = 0;
        for (int i : this.kasi.getSilmaluvut()) {
            summa += i;
        }
        return summa;
    }

    /**
     * Metodi laskee käden silmälukuja vastaavat pisteet sarakkeelle yatzy.
     * 
     * 
     * @return kättä vastaava pistemäärä
     */
    public int yatzy() {
        int[] jarj = jarjestaSilmaluvut();
        for (int i = 0; i < 6; i++) {
            if (jarj[i] == 5) {
                return 50;
            }
        }
        return 0;
    }

    /**
     * Metodi laskee tallennettujen pisteiden perusteella numerosarakkeiden pisteiden summan.
     * 
     * 
     * @return laskettu välisumma
     */
    public int valisumma() {
        int valisumma = osaSumma(0, 6);
        if (valisumma >= 63) {
            valisumma += 50;
        }
        return valisumma;
    }

    /**
     * Palauttaa sarakken "VÄLISUMMA" arvon.
     * 
     * @return välsumma taulukosta
     */
    public int getValisumma() {
        return this.pisteet[6];
    }

    /**
     * Metodi laskee tallennettujen pisteiden perusteella kaikkien sarakkeiden pisteiden summan.
     * 
     * 
     * @return laskettu summa
     */
    public int summa() {
        return valisumma() + osaSumma(7, 15);
    }

    /**
     * Palauttaa sarakkeen "SUMMA" arvon.
     * 
     * @return summa taulukosta
     */
    public int getSumma() {
        return this.pisteet[16];
    }

    /**
     * Metodi laskee tallennettujen pisteiden summan annetusta alkusarakkeesta annettuunn loppusarakkeeseen.
     * 
     * @param alku ensimmäisen summattavan sarakkeen indeksi
     * @param loppu viimeisen summattavan sarakkeen indeksi
     * @return osasumma
     */
    public int osaSumma(int alku, int loppu) {
        int summa = 0;
        for (int i = alku; i < loppu; i++) {
            if (this.pisteet[i] != -1) {
                summa += this.pisteet[i];
            }
        }
        return summa;
    }

    /**
     * Metodi luo taulukon, jossa on kuusi saraketta. Kuhunkin taulukon kohtaan
     * kirjataan kuinka monta kappaletta kyseistä silmäluvua on.
     *
     * @return int[] jossa eri silmälukujen lukumäärät.
     */
    public int[] jarjestaSilmaluvut() {
        int[] jarjestetty = new int[6];
        for (int i = 0; i < 6; i++) {
            jarjestetty[i] = 0;
        }
        for (int j : this.kasi.getSilmaluvut()) {
            jarjestetty[j - 1]++;
        }
        return jarjestetty;
    }
    
// ei nykyisellään tarvetta tälle metodille
//    public boolean onTaysi() {
//        for (int piste : this.pisteet) {
//            if (piste == -1) {
//                return false;
//            }
//        }
//        return true;
//    }
}
