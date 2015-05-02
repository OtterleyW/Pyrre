package pyrre.pyrre.kortit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka kuvaa pelissä olevaa korttipakkaa ja tarjoaa sen toimintaan metodeja.
 *
 * @author Jenni
 */
public class Korttipakka {

    private ArrayList<Kortti> pakka = new ArrayList<Kortti>();
    private ArrayList<Kortti> poistopakka = new ArrayList<Kortti>();
    private int kerrat = 0;

    /**
     * Metodi luo korttipakan, joka sisältää yhteensä 52 korttia (13 kutakin
     * maata)
     */
    public void LuoKorttipakka() {
        for (int i = 0; i <= 3; i++) {
            for (int u = 1; u <= 13; u++) {
                Kortti kortti = new Kortti(u, i);
                pakka.add(kortti);
            }
        }
    }

    public ArrayList<Kortti> getPakka() {
        return pakka;
    }

    public int getPakanKoko() {
        int koko = pakka.size();
        return koko;
    }

    public ArrayList<Kortti> getPoistopakka() {
        return poistopakka;
    }

    /**
     * Sekoittaa korttipakan
     */
    public void sekoitaKorttipakka() {
        Collections.shuffle(pakka);
    }

    /**
     * Nostaa pakan päälimmäisen eli indeksissä 0 olevan kortin ja poistaa sen
     * sitten pakasta. Nostettu kortti talletetaan poistopakkaan.
     *
     * @return nostettu kortti
     */
    public Kortti nostaPaalimmainen() {
        
        if (pakka.size() == 0 && kerrat < 3) {
            for (Kortti kortti : poistopakka) {
                if (kortti.getPaikka() == "pakka") {
                    pakka.add(kortti);
                }
            }
            poistopakka.clear();
            kerrat++;
            System.out.println("Pakka alkaa alusta + " + kerrat);
        }
        Kortti kortti = pakka.get(0);
        poistopakka.add(kortti);
        pakka.remove(0);
        
        if(kerrat >= 3 && pakka.size()==0){
            kortti.setPaikka("loppu");
        }
        return kortti;
    }

}
