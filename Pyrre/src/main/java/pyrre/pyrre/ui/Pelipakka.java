/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.ui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.kortit.Korttipakka;
import pyrre.pyrre.logiikka.Pelialusta;
import pyrre.pyrre.logiikka.Pelilogiikka;

/**
 * Kuvastaa pelipakkaa käyttöliittymässä
 *
 * @author Jenni
 */
public class Pelipakka extends JPanel {

    private Pelialusta alusta;
    private Pelilogiikka logiikka;
    private Kayttoliittyma kayttoliittyma;
    private Korttipakka pakka;
    private JButton pakkabutton;
    private JButton selaaKortteja;
    private Kortti kortti;
    private Pakanselaus pakanselaus = new Pakanselaus(this);

    /**
     * Luo pelipakan
     *
     * @param alusta Pelialusta
     * @param logiikka Pelilogiikka
     * @param kayttoliittyma Käyttöliittymä
     */
    public Pelipakka(Pelialusta alusta, Pelilogiikka logiikka, Kayttoliittyma kayttoliittyma) {
        super(new GridLayout(1, 2));
        this.alusta = alusta;
        this.logiikka = logiikka;
        this.kayttoliittyma = kayttoliittyma;
        this.pakka = logiikka.getPelipakka();

        luoPakka();
    }

    /**
     * Luo pelipakkaa kuvastavan JButtonin
     */
    public void luoPakka() {
        System.out.println("Luo pakat");
        kortti = pakka.nostaPaalimmainen();

        this.pakkabutton = new JButton(kortti.toString());
        this.pakkabutton.addActionListener(new Pakkakuuntelija(this.logiikka, this.kayttoliittyma, this));
        this.pakkabutton.setVisible(true);
        this.add(this.pakkabutton);

        selaaKortteja = new JButton("seuraava kortti");
        selaaKortteja.addActionListener(pakanselaus);
        selaaKortteja.setVisible(true);
        this.add(selaaKortteja);
    }

    public Kortti getPaalimmainenKortti() {
        return this.kortti;
    }

    /**
     * Asettaa JButonille uuden kortin tekstin
     */
    public void nostaKortti() {
        kortti = pakka.nostaPaalimmainen();
        if(kortti.getPaikka() == "loppu"){
            pakkaLoppu();
        }
        this.pakkabutton.setText(kortti.toString());

    }
    
    public void pakkaLoppu() {
        selaaKortteja.setText("Kortit loppuivat");
        selaaKortteja.removeActionListener(pakanselaus);
        selaaKortteja.setBackground(Color.gray);
    }
    /**
     * Päivittää ruudun siten, että jos kortin paikka on poistettu, nostetaan
     * uusi kortti
     */
    public void paivitaRuutu() {
        if (kortti.getPaikka() == "poistettu") {
            nostaKortti();
        }
        
    }

}
