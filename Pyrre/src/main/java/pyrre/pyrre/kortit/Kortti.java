
package pyrre.pyrre.kortit;

public class Kortti {

    //Asetetaan kortille staattiset muuttujat, jotta maiden ja arvojen muuttaminen selkokieliseksi olisi helpompaa
    public static final int RISTI = 0;
    public static final int RUUTU = 1;
    public static final int HERTTA = 2;
    public static final int PATA = 3;
    public static final int TYHJA = 4;

    public static final String[] MAAT = {" Risti", " Ruutu", "Hertta", "  Pata", "     "};
    public static final String[] ARVOT = {"  ", "A ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 ", "8 ", "9 ", "10", "J ", "Q ", "K "};

    private int arvo;
    private int maa;
    private String paikka;
    
    //Pöydällä olevien korttien paikat
    private int rivi;
    private int sarake;
    
    //Jokaisella kortilla on sekä maa että arvo, lisäksi asetetaan paikka, joka oletuksena on pakka
    public Kortti(int arvo, int maa) {
        this.arvo = arvo;
        this.maa = maa;
        this.paikka = "pakka";
    }
    
    public Kortti LuoTyhjaKortti() {
        Kortti tyhja = new Kortti(0,4);
        return tyhja;
    }

    @Override
    public String toString() {
        return MAAT[maa] + " " + ARVOT[arvo];
    }
    
    //Palauttaa kortin arvon kokonaislukuna
    public int getArvo() {
        return arvo;
    }

    //Palauttaa kortin maan kokonaislukuna
    public int getMaa() {
        return maa;
    }
    
    //asettaa paikan pöydällä 
    public void asetaPaikkaPoydalla(int i, int j){
        this.rivi = i;
        this.sarake = j;
        this.paikka = "poyta";
    }
    
    //Haetaan paikat pöydällä
    public int getRivi(){
        return this.rivi;
    }
    
    public int getSarake(){
        return this.sarake;
    }
    
    public void asetaPaikka(String paikka){
        this.paikka = paikka;
    }
    public String getPaikka(){
        return this.paikka;
    }
    

    
    
  
}
