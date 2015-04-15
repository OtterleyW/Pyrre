/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.logiikka.Pelialusta;
import pyrre.pyrre.logiikka.Pelilogiikka;
import pyrre.pyrre.logiikka.Pelisaannot;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Pelialusta alusta;
    private Pelilogiikka logiikka;
    private Container container;
    private Pelikentta pelikentta;
    private Pelipakka korttipakka;

    public Kayttoliittyma(Pelialusta alusta, Pelilogiikka logiikka) {
        this.alusta = alusta;
        this.logiikka = logiikka;
    }

    @Override
    public void run() {
        frame = new JFrame("Pyramidipasianssi");
        frame.setPreferredSize(new Dimension(1200, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.container = frame.getContentPane();
        luoKomponentit(this.container);

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JLabel teksti = new JLabel("Pyramidipasianssi");
        container.add(teksti);
        this.pelikentta = luoPelikentta();
        container.add(this.pelikentta);
        this.korttipakka = luoKorttipakka();
        container.add(this.korttipakka, BorderLayout.SOUTH);
    }

    private Pelikentta luoPelikentta() {
        Pelikentta pelikentta = new Pelikentta(this.alusta, this.logiikka, this);
        return pelikentta;
    }

    private Pelipakka luoKorttipakka() {
        Pelipakka korttipakka = new Pelipakka(this.alusta, this.logiikka, this);
        return korttipakka;
    }

    public void paivitaRuutu() {
        System.out.println("reepaint");
        pelikentta.paivitaRuutu();
        korttipakka.paivitaRuutu();
        container.repaint();
    }

    public JFrame getFrame() {
        return frame;
    }
}
