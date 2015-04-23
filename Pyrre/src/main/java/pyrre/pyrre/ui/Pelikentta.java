package pyrre.pyrre.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.logiikka.Pelialusta;
import pyrre.pyrre.logiikka.Pelilogiikka;

/**
 * Käyttöliittymän pelikenttä, joka kuvaa pöydällä olevia kortteja
 *
 * @author Jenni
 */
public class Pelikentta extends JPanel {
    
    private Pelialusta alusta;
    private Pelilogiikka logiikka;
    private Kayttoliittyma kayttoliittyma;
    private JButton[][] buttonit;
    private Kortti[][] kortit;

    /**
     * Luo uuden pelikentän
     *
     * @param alusta Pelialusta
     * @param logiikka Pelilogiika
     * @param kayttoliittyma Käyttöliittymä
     */
    public Pelikentta(Pelialusta alusta, Pelilogiikka logiikka, Kayttoliittyma kayttoliittyma) {
        super(new GridLayout(7, 13));
        this.alusta = alusta;
        this.logiikka = logiikka;
        this.kayttoliittyma = kayttoliittyma;
        this.kortit = alusta.getPelialusta();
        this.buttonit = new JButton[7][13];
        
        this.luoButtonit();
    }

    /**
     * Luo pelikentälle JButtonit, jotka edustavat pelissä olevia kortteja
     */
    private void luoButtonit() {
        System.out.println("Luo buttonit");
        
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 13; j++) {
                JButton button = new JButton(kortit[i][j].toString());
                button.setVisible(false);
                if (kortit[i][j].getArvo() != 0) {
                    button.addActionListener(new Poytakuuntelija(kortit[i][j], this.logiikka, this.kayttoliittyma));
                    button.setVisible(true);
                }
                buttonit[i][j] = button;
                this.add(button);
                
            }
            
        }
        
    }
    
    /**
     * Päivittää kentällä olevat JButtonit siten, että kortit, joiden paikka on "poistettu" piilotetaan
     */
    public void paivitaButtonit() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 13; j++) {
                if (kortit[i][j].getPaikka() == "poistettu") {
                    JButton button = buttonit[i][j];
                    button.setVisible(false);
                    if(i == 0 && j == 6) {
                        button.setText("Voitit pelin!");
                        button.setBackground(Color.pink);
                        button.setVisible(true);
                    }
                     
                }
                
            }
        }
    }
    
    /**
     * Suorittaa paivitaButtonit metodin
     */
    public void paivitaRuutu() {
        paivitaButtonit();
    }
}
