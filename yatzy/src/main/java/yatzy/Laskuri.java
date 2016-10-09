package yatzy;

/**
 * Laskuri laskee mikä arvo valittuun sarakkeeeen tallennetaan.
 */
public class Laskuri {
    private Kasi kasi;

    /**
     * Konstruktori asettaa laskurille Käsi-muuttujan.
     * 
     * @param kasi käsi, josta laskuri hakee noppien tilan
     */
    public Laskuri(Kasi kasi) {
        this.kasi = kasi;
    }

    /**
     * laskeSarakkeenPisteet(String sarake) laskee kyseisen sarakkeen laskukaavalla sarakkeeseen tallennettavat pisteet. 
     * 
     * @param sarake Sarakkeen nimi, johon tulos tallennetaan
     * @return sarakkeeseeen tallennettavat pisteet
     */
    public int laskeSarakkeenPisteet(String sarake) {
        return -1;
    }

}
