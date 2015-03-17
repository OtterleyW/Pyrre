/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre;

/**
 *
 * @author Jenni
 */
public class Kortti {

    public static final int RISTI = 0;
    public static final int RUUTU = 1;
    public static final int HERTTA = 2;
    public static final int PATA = 3;
    
    public static final String[] MAAT = {"Risti", "Ruutu", "Hertta", "Pata"};
    public static final String[] ARVOT = {"-", "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    
    private int arvo;
    private int maa;
    private String paikka;

    public Kortti(int arvo, int maa) {
        this.arvo = arvo;
        this.maa = maa;
        this.paikka = "pakka";
    }
    
    public void asetaUusiPaikka(String paikka){
        this.paikka = paikka;
    }

    @Override
    public String toString() {
        return MAAT[maa] + " " + ARVOT[arvo];
    }

    public int getArvo() {
        return arvo;
    }

    public int getMaa() {
        return maa;
    }

    

}
