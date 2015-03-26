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
    
    //Sekoittaa korttipakan
    public void sekoitaKorttipakka() {
        Collections.shuffle(pakka);
    }
    
    //palauttaa korttipakan ArrayListina
    public ArrayList<Kortti> getPakka() {
        return pakka;
    }
    
    //nostaa pakan päälimmäisen eli indeksissä 0 olevan kortin ja poistaa sen sitten pakasta
    public Kortti nostaPaalimmainen() {
        if (pakka.size() == 0){
            Kortti kortti = new Kortti(0,4);
            kortti = kortti.LuoTyhjaKortti();
            return kortti;
        }
        Kortti kortti = pakka.get(0);
        pakka.remove(0);
        return kortti;
                
    }
    
    //nostaa pakan päälimmäisen eli indeksissä 0 olevan kortin mutta ei poista sita
    public Kortti nostaPaalimmainenPoistamatta() {
        if (pakka.size() == 0){
            Kortti kortti = new Kortti(0,4);
            kortti = kortti.LuoTyhjaKortti();
            return kortti;
        }
        Kortti kortti = pakka.get(0);
        return kortti;
    }
    
    
    //poistaa kortin pakasta ja lisää sen poistopakkaan
    public void asetaPoistopakkaan(Kortti kortti) {
        pakka.remove(kortti);
        poistopakka.add(kortti);
    }
    
    
    //palauttaa poistopakan (pelin kannalta ei merkitystä)
    public ArrayList<Kortti> getPoistopakka(){
        return poistopakka;
    }
    
    //Poistetaan kortti
    public void poistaKortti(Kortti kortti) {
        pakka.remove(kortti);
    }

}
