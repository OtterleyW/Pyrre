/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.ui;

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

    public Kayttoliittyma(Pelialusta alusta, Pelilogiikka logiikka) {
        this.alusta = alusta;
        this.logiikka = logiikka;
    }

    @Override
    public void run() {
        frame = new JFrame("Pyramidipasianssi");
        frame.setPreferredSize(new Dimension(1500, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        this.container = frame.getContentPane();
        luoKomponentit(this.container);

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JLabel teksti = new JLabel("Pyramidipasianssi");
        container.add(teksti);
        container.add(luoPelikentta(this.alusta));
    }

    private JPanel luoPelikentta(Pelialusta alusta) {
        JPanel panel = new JPanel(new GridLayout(7, 13));
        Kortti[][] kortit = alusta.getPelialusta();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 13; j++) {
                
                    JButton button = new JButton(kortit[i][j].toString());
                    
                    if((kortit[i][j].getArvo() != 0) && kortit[i][j].getPaikka() != "Poistopakka"){
                    button.addActionListener(new Kuuntelija(kortit[i][j], this.logiikka, this));
                    }
                    
                    panel.add(button);
                
            }
            
        }
        return panel;
    }
    
    public void paivitaRuutu() {
        System.out.println("reepaint");
       container.repaint();
    }

    public JFrame getFrame() {
        return frame;
    }
}
