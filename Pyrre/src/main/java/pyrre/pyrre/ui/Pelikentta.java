package pyrre.pyrre.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
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
    public static final int KORKEUS = Math.round(KorttiButton.KORKEUS * 7 * 0.8f + (KorttiButton.KORKEUS - (KorttiButton.KORKEUS * 0.8f)));
    public static final int LEVEYS = Math.round(KorttiButton.LEVEYS * 13 * 0.8f + (KorttiButton.LEVEYS - (KorttiButton.LEVEYS * 0.8f)));
    
    private Pelialusta alusta;
    private Pelilogiikka logiikka;
    private Kayttoliittyma kayttoliittyma;
    private KorttiButton[][] buttonit;
    private Kortti[][] kortit;

    /**
     * Luo uuden pelikentän
     *
     * @param alusta Pelialusta
     * @param logiikka Pelilogiika
     * @param kayttoliittyma Käyttöliittymä
     */
    public Pelikentta(Pelialusta alusta, Pelilogiikka logiikka, Kayttoliittyma kayttoliittyma) {
        super();
        this.setLayout(null);
        this.alusta = alusta;
        this.logiikka = logiikka;
        this.kayttoliittyma = kayttoliittyma;
        this.kortit = alusta.getPelialusta();
        this.buttonit = new KorttiButton[7][13];
        
        this.luoButtonit();
        this.setOpaque(false);
    }

    /**
     * Luo pelikentälle KorttiButtonit, jotka edustavat pelissä olevia kortteja
     */
    private void luoButtonit() {
        System.out.println("Luo buttonit");
        
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 13; j++) {
                KorttiButton button = new KorttiButton(kortit[i][j]);
                button.setVisible(false);
                if (kortit[i][j].getArvo() != 0) {
                    button.addActionListener(new Poytakuuntelija(kortit[i][j], this.logiikka, this.kayttoliittyma));
                    button.setVisible(true);
                }
                buttonit[i][j] = button;
                this.add(button);
                this.setComponentZOrder(button, 0);
                int y = Math.round((KorttiButton.KORKEUS*i*0.8f));
                int x = Math.round((KorttiButton.LEVEYS*j*0.8f));
                
                Insets insets = this.getInsets();
                button.setBounds(insets.left+x, insets.top+y, KorttiButton.LEVEYS, KorttiButton.KORKEUS);
            }
            
        }
        
        this.validate();
        
    }
    
    /**
     * Päivittää kentällä olevat KorttiButtonit siten, että kortit, joiden paikka on "poistettu" piilotetaan
     */
    public void paivitaButtonit() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 13; j++) {
                KorttiButton button = buttonit[i][j];
                Kortti kortti = kortit[i][j];
                if (kortti.getPaikka() == "poistettu") {
                    button.setVisible(false);
                    if(i == 0 && j == 6) {
                        kayttoliittyma.voititPelin();
                    }
                }
                if (logiikka.onkoKorttiValittu(kortti)) {
                    button.asetaValituksi(true);
                }
                else {
                    button.asetaValituksi(false);
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
    
    @Override
    public boolean isOptimizedDrawingEnabled() {
        return false;
    }
}
