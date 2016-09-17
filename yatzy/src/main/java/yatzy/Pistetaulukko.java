
package yatzy;


public class Pistetaulukko {
    private Sarake[] sarakkeet;
    
    public Pistetaulukko() {
        this.sarakkeet = new Sarake[15];
        for (int i = 0; i < 15; i++) {
            this.sarakkeet[i] = new Sarake();
        }
    }
    
    public int valisumma() {
        return summa(5); //Testaa hyvin
    }
    
    public int loppusumma() {
        return summa(15); //Testaa hyvin
    }
    
    public int summa(int kuinkaPitkalle) {   //Testaa hyvin
        int summa = 0;
        for (int i = 0; i <= kuinkaPitkalle; i++) {
            if (this.sarakkeet[i].getPisteet() != -1) {
                summa += this.sarakkeet[i].getPisteet();
            }
        }
        return summa;
    }
    
    public void laskeJaTallennaPisteet(Kasi kasi, Sarake sarake) {
        //todo
    }
    
    public boolean onTaysi() {
        for (Sarake sarake : sarakkeet) {
            if (sarake.getPisteet() == -1) {
                return false;
            }
        }
        return true;
    }
}
