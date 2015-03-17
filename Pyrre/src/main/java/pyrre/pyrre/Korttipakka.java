/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jenni
 */
public class Korttipakka {
    private ArrayList<Kortti> pakka = new ArrayList<Kortti>();
    
    public void LuoKorttipakka() {
        for (int i=0; i <= 3; i++){
            for (int u=1; u <= 13; u++){
                Kortti kortti = new Kortti(u, i);
                pakka.add(kortti);
            }
        }
    }
    
    public Kortti palautaTiettyKortti(int i) {
        Kortti kortti = pakka.get(i);
        return kortti;
    } 
    
    public void sekoitaKorttipakka()
	{
            Collections.shuffle(pakka);
	}
    
    public Kortti nostaPaalimmainen(){
        Kortti kortti = pakka.get(0);
        return kortti;
    }
    
    public void tulostaKorttipakka() {
        for (Kortti kortti: pakka){
            System.out.println(kortti.toString());
            
        }
    }
    
    
}
