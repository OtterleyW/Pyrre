package pyrre.pyrre.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import pyrre.pyrre.Paaohjelma;
import pyrre.pyrre.kortit.Kortti;
import pyrre.pyrre.logiikka.Pelialusta;
import pyrre.pyrre.logiikka.Pelilogiikka;
import pyrre.pyrre.logiikka.Pelisaannot;

/**
 * Ohjelman graafinen käyttöliittymä
 *
 * @author Jenni
 */
public class Kayttoliittyma implements Runnable {
    public static final int IKKUNA_LEVEYS = 1200;
    public static final int IKKUNA_KORKEUS = 850;
    
    private JFrame frame;
    private Pelialusta alusta;
    private Pelilogiikka logiikka;
    private Container container;
    private Pelikentta pelikentta;
    private Pelipakka korttipakka;

    /**
     * Luo uuden käyttöliittymän
     *
     * @param alusta Pelissä luotu pelialusta
     * @param logiikka Pelissä luotu pelilogiikka
     */
    public Kayttoliittyma(Pelialusta alusta, Pelilogiikka logiikka) {
        this.alusta = alusta;
        this.logiikka = logiikka;
    }

    @Override
    public void run() {
        frame = new JFrame("Pyramidipasianssi");
        frame.setPreferredSize(new Dimension(IKKUNA_LEVEYS, IKKUNA_KORKEUS));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.container = frame.getContentPane();
        container.setLayout(null);
        luoKomponentit(this.container);

        frame.pack();
        frame.setVisible(true);
        
        Insets insets = frame.getInsets();
        frame.setSize(IKKUNA_LEVEYS + insets.left + insets.right,
              IKKUNA_KORKEUS + insets.top + insets.bottom);
    }

    /**
     * Luo käyttöliittymään vaaditut komponentit
     *
     * @param container Sisältää komponentit
     */
    private void luoKomponentit(Container container) {
        this.pelikentta = luoPelikentta();
        container.add(this.pelikentta);
        this.korttipakka = luoKorttipakka();
        container.add(this.korttipakka, BorderLayout.SOUTH);
        
        Insets insets = container.getInsets();
        this.pelikentta.setBounds(insets.left+(IKKUNA_LEVEYS - Pelikentta.LEVEYS)/2, insets.top, Pelikentta.LEVEYS, Pelikentta.KORKEUS);
        this.korttipakka.setBounds(insets.left+(IKKUNA_LEVEYS - Pelikentta.LEVEYS)/2, insets.top + IKKUNA_KORKEUS - KorttiButton.KORKEUS, Pelikentta.LEVEYS , KorttiButton.KORKEUS);
        
        this.korttipakka.luoPakka();
        
        container.setBackground(Color.getHSBColor(0.4f, 0.5f, 0.4f));
        
        
    }

    /**
     * Luo käyttöliittymään näkymän pelikentästä
     *
     * @return käyttöliittymän pelikenttä
     */
    private Pelikentta luoPelikentta() {
        Pelikentta pelikentta = new Pelikentta(this.alusta, this.logiikka, this);
        return pelikentta;
    }

    /**
     * Luo käyttöliittymään näkymän pelipakasta
     *
     * @return käyttöliittymän pelipakka
     */
    private Pelipakka luoKorttipakka() {
        Pelipakka korttipakka = new Pelipakka(this.alusta, this.logiikka, this);
        return korttipakka;
    }

    /**
     * Päivittää käyttöliittymän näkymän
     */
    public void paivitaRuutu() {
        pelikentta.paivitaRuutu();
        korttipakka.paivitaRuutu();
        container.repaint();
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public void voititPelin() {
        Object[] options = {"Aloita uusi peli", "Lopeta peli"};
        int valinta = JOptionPane.showOptionDialog(frame,
                "Voitit pelin",
                "Peli loppui",
                JOptionPane.OK_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
        frame.dispose();
        if (valinta == 0) {
            Paaohjelma.aloitaUusiPeli();
        }
    }
    
    public void havisitPelin(){
        Object[] options = {"Aloita uusi peli", "Lopeta peli"};
        int valinta = JOptionPane.showOptionDialog(frame,
                "Hävisit pelin",
                "Peli loppui",
                JOptionPane.OK_OPTION,
                JOptionPane.ERROR_MESSAGE,
                null,
                options,
                options[0]);
        frame.dispose();
        if (valinta == 0) {
            Paaohjelma.aloitaUusiPeli();
        }
    }
}
