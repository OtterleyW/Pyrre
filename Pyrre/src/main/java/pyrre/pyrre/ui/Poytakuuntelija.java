/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.ui;

/**
 * 
 * @author Jenni
 */
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.logiikka.Pelilogiikka;
import pyrre.pyrre.logiikka.Pelisaannot;

public class Poytakuuntelija implements ActionListener {

    private Kortti kortti;
    private Pelilogiikka logiikka;
    private Kayttoliittyma liittyma;
    
    public Poytakuuntelija(Kortti kortti, Pelilogiikka logiikka, Kayttoliittyma liittyma) {
        this.kortti = kortti;
        this.logiikka = logiikka;
        this.liittyma = liittyma;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        logiikka.valitsePoydaltaKortti(this.kortti);
        liittyma.paivitaRuutu();
    }
}
