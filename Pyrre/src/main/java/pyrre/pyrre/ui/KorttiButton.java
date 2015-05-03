/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.ui;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import pyrre.pyrre.kortit.Kortti;

/**
 * JButton, joka on erikoistunut näyttämään kortteja
 *
 * @author Jenni
 */
public class KorttiButton extends JButton {

    public static final int KORKEUS = 100;
    public static final int LEVEYS = 69;

    private static final String[] MAAT_IMG = {"clubs", "diamonds", "hearts", "spades"};
    private static final String[] ARVOT_IMG = {null, "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    private ImageIcon kuva;

    /**
     * Luo uuden KorttiButtonin, jolle asetetaan kortin leveys, korkeus ja
     * haluttu kuva
     *
     * @param kortti näytettävä kortti
     */
    public KorttiButton(Kortti kortti) {
        super();
        this.setSize(LEVEYS, KORKEUS);
        this.setBorder(null);

        setKuva(kortti);

    }

    private String kortinNimi(Kortti kortti) {
        String maa = MAAT_IMG[kortti.getMaa()];
        String arvo = ARVOT_IMG[kortti.getArvo()];
        return arvo + "_of_" + maa;
    }

    /**
     * Asettaa kortin maan ja arvon perusteella oikean kuvan näkyviin
     * @param kortti näytettävä kortti
     */
    public void setKuva(Kortti kortti) {
        if (kortti.getArvo() != 0) {
            try {
                String polku = "/kuvat/cards/" + kortinNimi(kortti) + ".png";
                URL tiedostoUrl = KorttiButton.class.getResource(polku);
                kuva = new ImageIcon(ImageIO.read(tiedostoUrl));
                this.setIcon(kuva);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Jos kortti on valittu pelissä, korostetaan kortti
     * @param onValittu boolean onko kortti valittu
     */
    public void asetaValituksi(boolean onValittu) {
        if (onValittu) {
            this.setBorder(BorderFactory.createLineBorder(Color.red, 3));
        } else {
            this.setBorder(null);
        }
    }

}
