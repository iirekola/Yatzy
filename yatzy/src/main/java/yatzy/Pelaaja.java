
package yatzy;

public class Pelaaja {
    private String nimi;
    private Pistetaulukko pisteet;
    
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = new Pistetaulukko();
    }
    
    public Pelaaja() {
        this.nimi = "nimetön";
        this.pisteet = new Pistetaulukko();
    }
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public Pistetaulukko getPisteet() {
        return this.pisteet;
    }
    
}
