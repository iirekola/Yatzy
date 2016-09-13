
package yatzy;

public class Sarake {
    private String nimi;
    private int pisteet;
    
    public Sarake(String nimi) {
        this.nimi = nimi;
        this.pisteet = -1;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
    public void merkitsePisteet(int pisteet) {
        this.pisteet = pisteet;
    }
}
