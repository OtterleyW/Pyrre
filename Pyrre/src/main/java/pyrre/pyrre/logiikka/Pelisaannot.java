/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyrre.pyrre.logiikka;

import pyrre.pyrre.kortit.Kortti;

/**
 *
 * @author Jenni
 */
public class Pelisaannot {

    private Pelialusta alusta;

    public Pelisaannot(Pelialusta alusta) {
        this.alusta = alusta;
    }

    public boolean voikoKortinValita(Kortti kortti) {
        int rivi = kortti.getRivi();
        if (rivi == 6) {
            return true;
        } else {
            Kortti alaVasen = haeAlaVasenKortti(kortti);
            Kortti alaOikea = haeAlaOikeaKortti(kortti);
            if (alaVasen.getArvo() == 0 && alaOikea.getArvo() == 0) {
                return true;
            }
        }
        return false;
    }

    public Kortti haeAlaVasenKortti(Kortti kortti) {
        int rivi = (kortti.getRivi() + 1);
        int sarake = (kortti.getSarake() - 1);

        Kortti vasenKortti = this.alusta.valitseKortti(rivi, sarake);

        return vasenKortti;
    }

    public Kortti haeAlaOikeaKortti(Kortti kortti) {
        int rivi = (kortti.getRivi() + 1);
        int sarake = (kortti.getSarake() + 1);

        Kortti oikeaKortti = this.alusta.valitseKortti(rivi, sarake);

        return oikeaKortti;
    }
}
