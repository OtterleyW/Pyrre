package pyrre.pyrre.kortit;

/**
 * Luokka kuvaa pelissä olevia yksittäisiä kortteja. Siihen on tallennettu
 * kortin arvo, maa ja paikka pelissä.
 *
 * @author Jenni
 */
public class Kortti {

    /**
     * Asetetaan kortille staattiset muuttujat maalle ja arvolle, jotta niiden
     * muuttaminen selkokieliseksi pelissä olisi helpompaa
     */
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

    /**
     * Pöydällä olevien korttien paikat. Jos kortti ei ole pöydällä on arvo -1.
     */
    private int rivi = -1;
    private int sarake = 1;

    /**
     * Jokaisella kortilla on sekä maa että arvo, lisäksi asetetaan paikka, joka
     * oletuksena on pakka
     */
    public Kortti(int arvo, int maa) {
        this.arvo = arvo;
        this.maa = maa;
        this.paikka = "pakka";
    }

    /**
     * Luo tyhjän kortin, jonka arvo on 0 ja maan tunnus 4. Käytetään
     * pelialustan luomisessa.
     *
     * @return tyhjä kortti
     */
    public Kortti LuoTyhjaKortti() {
        Kortti tyhja = new Kortti(0, 4);
        return tyhja;
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

    /**
     * Asettaa paikan pöydällä
     *
     * @param i Kortin rivi pöydällä
     * @param j Kortin sarake pöydällä
     */
    public void asetaPaikkaPoydalla(int i, int j) {
        this.rivi = i;
        this.sarake = j;
        this.paikka = "poyta";
    }

    public int getRivi() {
        return this.rivi;
    }

    public int getSarake() {
        return this.sarake;
    }

    public void setPaikka(String paikka) {
        this.paikka = paikka;
    }

    public String getPaikka() {
        return this.paikka;
    }

    /**
     * Asettaa kortin paikaksi "poistettu", mutta ei vaikuta kortin arvoon.
     */
    public void poista() {
        this.paikka = "poistettu";
    }

}
