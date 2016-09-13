
package yatzy;


public class Pistetaulukko {
    Sarake[] sarakkeet;
    
    public Pistetaulukko() {
        this.sarakkeet = new Sarake[15];
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
}
