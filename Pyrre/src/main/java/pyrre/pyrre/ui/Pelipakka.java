/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.ui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;
import pyrre.pyrre.logiikka.Pelialusta;
import pyrre.pyrre.logiikka.Pelilogiikka;

/**
 *
 * @author Jenni
 */
public class Pelipakka extends JPanel {
    
    private Pelialusta alusta;
    private Pelilogiikka logiikka;
    private Kayttoliittyma kayttoliittyma;
    private Korttipakka pakka;
    private JButton pakkabutton;
    private Kortti kortti;

    public Pelipakka(Pelialusta alusta, Pelilogiikka logiikka, Kayttoliittyma kayttoliittyma) {
        super(new GridLayout(1, 2));
        this.alusta = alusta;
        this.logiikka = logiikka;
        this.kayttoliittyma = kayttoliittyma;
        this.pakka = logiikka.getPelipakka();
        
        luoPakka();
    }
    
    public void luoPakka(){
        System.out.println("Luo pakat");
        kortti = pakka.nostaPaalimmainen();
        
        this.pakkabutton = new JButton(kortti.toString());
        this.pakkabutton.addActionListener(new Pakkakuuntelija(this.logiikka, this.kayttoliittyma, this));
        this.pakkabutton.setVisible(true);
        this.add(this.pakkabutton);
        
        JButton selaaKortteja = new JButton("seuraava kortti");
        selaaKortteja.addActionListener(new Pakanselaus(this));
        selaaKortteja.setVisible(true);
        this.add(selaaKortteja);
    }
    
    public Kortti getPaalimmainenKortti(){
        return this.kortti;
    }
    
       public void nostaKortti() {
        kortti = pakka.nostaPaalimmainen();
        this.pakkabutton.setText(kortti.toString()); 
 
    }
       
       public void paivitaRuutu() {
           if(kortti.getPaikka() == "poistettu"){
               nostaKortti();
           }
    }

}
