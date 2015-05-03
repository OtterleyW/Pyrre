/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
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
    private KorttiButton pakkabutton;
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
        super();
        this.setLayout(null);
        this.alusta = alusta;
        this.logiikka = logiikka;
        this.kayttoliittyma = kayttoliittyma;
        this.pakka = logiikka.getPelipakka();
        this.setOpaque(false);
    }

    /**
     * Luo pelipakkaa kuvastavan JButtonin
     */
    public void luoPakka() {
        kortti = pakka.nostaPaalimmainen();

        this.pakkabutton = new KorttiButton(kortti);
        this.pakkabutton.addActionListener(new Pakkakuuntelija(this.logiikka, this.kayttoliittyma, this));
        this.pakkabutton.setVisible(true);
        this.add(this.pakkabutton);

        selaaKortteja = new JButton("seuraava kortti");
        selaaKortteja.addActionListener(pakanselaus);
        selaaKortteja.setVisible(true);
        this.add(selaaKortteja);
        
        Insets insets = this.getInsets();
        Dimension size = selaaKortteja.getPreferredSize();
        int vali = 10;
        int kokoLeveys = pakkabutton.getWidth() + size.width + vali;
        pakkabutton.setBounds(insets.left+(this.getWidth()-kokoLeveys)/2, insets.top, pakkabutton.getWidth(), pakkabutton.getHeight());
        selaaKortteja.setBounds(insets.left+(this.getWidth()-kokoLeveys)/2+pakkabutton.getWidth()+ vali, insets.top + (pakkabutton.getHeight()-size.height)/2, size.width, size.height);
    }

    public Kortti getPaalimmainenKortti() {
        return this.kortti;
    }

    /**
     * Asettaa JButonille uuden kortin tekstin
     */
    public void nostaKortti() {
        kortti = pakka.nostaPaalimmainen();
        if (kortti.getPaikka() == "loppu") {
            pakkaLoppu();
        }
        this.pakkabutton.setKuva(kortti);

    }

    /**
     * Kun korttipakkaa on selattu sallitut kerrat, poistetaan pakan selaus
     * käytöstä.
     */
    public void pakkaLoppu() {
        selaaKortteja.setText("Kortit loppuivat");
        selaaKortteja.removeActionListener(pakanselaus);
        selaaKortteja.setBackground(Color.gray);
        kayttoliittyma.havisitPelin();
    }

    /**
     * Päivittää ruudun siten, että jos kortin paikka on poistettu, nostetaan
     * uusi kortti
     */
    public void paivitaRuutu() {
        if (kortti.getPaikka() == "poistettu") {
            nostaKortti();
        }
        
        if (logiikka.onkoKorttiValittu(kortti)) {
            pakkabutton.asetaValituksi(true);
        }
        else {
            pakkabutton.asetaValituksi(false);
        }

    }

}
