package main;

import java.util.ArrayList;
import yatzy.Arvojoukko;
import yatzy.Noppa;

public class Paaohjelma {

    
    public static void main(String[] args) {
       ArrayList<Integer> a = new ArrayList<Integer>();
       a.add(1);
       a.add(2);
       a.add(3);
       a.add(4);
       a.add(5);
       Arvojoukko b = new Arvojoukko(a);
        System.out.println(a.size());
       Noppa n = new Noppa(b);
       
       while (n.getArvo() != 5) {
           n.heitaNoppaa();
           System.out.println(n.getArvo());
       }
        
        
        
    }
    
}
