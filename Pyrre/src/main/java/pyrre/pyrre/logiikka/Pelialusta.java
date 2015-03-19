/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.logiikka;

import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;

/**
 *
 * @author Jenni
 */
public class Pelialusta {
    private Korttipakka pakka;
    private Kortti[][] pelialusta;
    
    public Pelialusta(Korttipakka pakka) {
        this.pakka = pakka;
        this.pelialusta = new Kortti[7][7];
               
    }
    //Asetetaan kortin pyramidin muotoon pöydälle. Taulukon tyhjiin paikkoihin luodaan "tyhjäkortti"
    public void asetaKortitPoydalle() {
        for(int i=0; i < 7; i++){
            for(int j=0; j < 7; j++){
              if(   
                i == 0 && j == 3 || 
                i == 1 && j == 2 || i == 1 && j == 4 || 
                i == 2 && j >= 2 && j <= 4 || 
                i == 3 && j >= 1 && j <= 2 || i == 3 && j >= 4 && j <= 5 || 
                i == 4 && j >= 1 && j <= 5 || 
                i == 5 && j >= 0 && j <= 2 || i == 5 && j >= 4 && j <= 6 || 
                i==6
                ){
                  asetaKortti(i,j);
              } 
              else{
                     asetaTyhjaKortti(i,j);
              }
            }
    }
    }
    
    public void asetaKortti(int i, int j){
        Kortti kortti = pakka.nostaPaalimmainen();
        kortti.asetaPaikkaPoydalla(i, j);
        pelialusta[i][j] = kortti;
    }
    
    public void asetaTyhjaKortti(int i, int j){
        Kortti kortti = luoTyhjaKortti();
        pelialusta[i][j] = kortti;
    }
    
    public Kortti luoTyhjaKortti(){
        Kortti tyhja = new Kortti(0,4);
        tyhja = tyhja.LuoTyhjaKortti();
        return tyhja;
    }
    
    public void tulostaPoyta(){
        for(int i = 0; i<pelialusta.length; i++){
            for(int j = 0; j<pelialusta[i].length; j++){
                System.out.print(" " + pelialusta[i][j].toString()+ " ");
            }
            System.out.println("");
        }
    }
    
}
    
   

