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
 * Luokka, joka reagoi siihen, kun pakan selaus -buttonia painetaan
 *
 * @author Jenni
 */
public class Pakanselaus implements ActionListener {

    private Pelipakka pakka;

    /**
     * Luo uuden ActionListenerin pakan selausta varten
     * @param pakka Käyttöliittymän pelipakka
     * @author Jenni
     */
    public Pakanselaus(Pelipakka pakka) {
        this.pakka = pakka;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        pakka.nostaKortti();
    }
}
