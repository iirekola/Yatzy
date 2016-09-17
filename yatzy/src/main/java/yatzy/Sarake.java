
package yatzy;

public class Sarake {
    private int pisteet;
    
    public Sarake() {
        this.pisteet = -1;
    }
    
    public int getPisteet() {
        return this.pisteet;
    }
    
    public void merkitsePisteet(int pisteet) {
        this.pisteet = pisteet;
    }
}
