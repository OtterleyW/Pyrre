/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.ui;

import javax.swing.JButton;

/**
 *
 * @author Jenni
 */
public class KorttiButton extends JButton {
    public static final int KORKEUS = 100;
    public static final int LEVEYS = 75;

    public KorttiButton(String teksti) {
        super(teksti);
        this.setSize(LEVEYS, KORKEUS);
    }
    
}
