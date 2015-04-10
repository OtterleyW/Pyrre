/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.ui;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.logiikka.Pelialusta;
import pyrre.pyrre.logiikka.Pelilogiikka;

/**
 *
 * @author Jenni
 */
public class Pelikentta extends JPanel {

    private Pelialusta alusta;
    private Pelilogiikka logiikka;
    private Kayttoliittyma kayttoliittyma;
    private JButton[][] buttonit;
    private Kortti[][] kortit;

    public Pelikentta(Pelialusta alusta, Pelilogiikka logiikka, Kayttoliittyma kayttoliittyma) {
        super(new GridLayout(7, 13));
        this.alusta = alusta;
        this.logiikka = logiikka;
        this.kayttoliittyma = kayttoliittyma;
        this.kortit = alusta.getPelialusta();
        this.buttonit = new JButton[7][13];

        this.luoButtonit();
    }

    private void luoButtonit() {
        System.out.println("Luo buttonit");

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 13; j++) {
                JButton button = new JButton(kortit[i][j].toString());
                button.setVisible(false);
                if ((kortit[i][j].getArvo() != 0) && kortit[i][j].getPaikka() != "Poistopakka") {
                    button.addActionListener(new Kuuntelija(kortit[i][j], this.logiikka, this.kayttoliittyma));
                    button.setVisible(true);
                }
                buttonit[i][j] = button;
                this.add(button);

            }

        }

    }

    public void paivitaButtonit() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 13; j++) {
                if (kortit[i][j].getArvo() == 0) {
                    JButton button = buttonit[i][j];
                    button.setVisible(false);
                }
            }
        }
    }

    public void paivitaRuutu() {
        System.out.println("Paivita pelikentta");
        paivitaButtonit();
    }
}
