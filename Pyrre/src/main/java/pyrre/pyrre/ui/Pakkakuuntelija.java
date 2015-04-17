package pyrre.pyrre.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.logiikka.Pelilogiikka;
import pyrre.pyrre.logiikka.Pelisaannot;

/**
 * Luokka, joka reagoi siihen, kun pakassa olevaa korttia klikataan
 *
 * @author Jenni
 */
public class Pakkakuuntelija implements ActionListener {

    
    private Pelilogiikka logiikka;
    private Kayttoliittyma liittyma;
    private Pelipakka pakka;

    /**
     * Luo uuden ActionListenerin käyttöliittymässä olevaa korttipakkaa varten
     *
     * @param logiikka Pelilogiikka
     * @param liittyma Käyttöliittymä
     * @param pakka Käyttöliittymän pelipakka
     */
    public Pakkakuuntelija(Pelilogiikka logiikka, Kayttoliittyma liittyma, Pelipakka pakka) {
        this.logiikka = logiikka;
        this.liittyma = liittyma;
        this.pakka = pakka;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Kortti kortti = pakka.getPaalimmainenKortti();
        logiikka.valitsePakastaKortti(kortti);
        liittyma.paivitaRuutu();
    }
}
