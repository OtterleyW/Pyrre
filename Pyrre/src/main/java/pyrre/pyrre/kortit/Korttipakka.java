package pyrre.pyrre.kortit;

import java.util.ArrayList;
import java.util.Collections;

public class Korttipakka {

    //Luodaan tyhjät listat korttipakkaa ja poistopakkaa varten

    private ArrayList<Kortti> pakka = new ArrayList<Kortti>();
    private ArrayList<Kortti> poistopakka = new ArrayList<Kortti>();
    
    //Luodaan korttipakka, joka sisältää 52 korttia
    public void LuoKorttipakka() {
        for (int i = 0; i <= 3; i++) {
            for (int u = 1; u <= 13; u++) {
                Kortti kortti = new Kortti(u, i);
                pakka.add(kortti);
            }
        }
    }

    //Tarkistetaan pakan korttien määrä
    public int TarkistaPakanKoko() {
        int koko = pakka.size();
        return koko;
    }

    //Palauttaa indeksissä i olevan kortin
    public Kortti palautaTiettyKortti(int i) {
        Kortti kortti = pakka.get(i);
        return kortti;
    }
    
    //Sekoittaa korttipakan
    public void sekoitaKorttipakka() {
        Collections.shuffle(pakka);
    }
    
    //nostaa pakan päälimmäisen eli indeksissä 0 olevan kortin ja poistaa sen sitten pakasta
    public Kortti nostaPaalimmainen() {
        Kortti kortti = pakka.get(0);
        pakka.remove(0);
        return kortti;
    }
    
    public ArrayList<Kortti> getPoistopakka(){
        return poistopakka;
    }
    
    

}
