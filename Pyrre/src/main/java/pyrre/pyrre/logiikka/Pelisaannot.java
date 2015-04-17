package pyrre.pyrre.logiikka;

import pyrre.pyrre.kortit.Kortti;

/**
 * Luokka tarjoaa metodin, jolla voi tarkistaa, onko tietty kortti pelattavissa
 * vai ei
 *
 * @author Jenni
 */
public class Pelisaannot {

    private Pelialusta alusta;

    /**
     * Tallentaa pelialustan pelisääntöjen tietoon
     *
     * @param alusta Pelissä oleva pelialusta
     */
    public Pelisaannot(Pelialusta alusta) {
        this.alusta = alusta;

    }

    /**
     * Tarkistaa, voiko kortin valita vai onko se lukittuna vielä toisten
     * korttien "alle"
     *
     * @param kortti Tarkasteltava kortti
     * @return boolean onko kortti valittavissa (true) vai ei (false)
     */
    public boolean voikoKortinValita(Kortti kortti) {
        int rivi = kortti.getRivi();
        if (rivi == 6) {
            return true;
        } else {
            Kortti alaVasen = haeAlaVasenKortti(kortti);
            Kortti alaOikea = haeAlaOikeaKortti(kortti);
            if (alaVasen.getPaikka() == "poistettu" && alaOikea.getPaikka() == "poistettu") {
                return true;
            }
        }
        return false;
    }

    /**
     * Hakee kortille tallennettujen rivin ja sarakkeen perusteella
     * alavasemmalla olevan kortin
     *
     * @param kortti Tarkasteltava kortti
     * @return alavasemmalla oleva kortti
     */
    public Kortti haeAlaVasenKortti(Kortti kortti) {
        int rivi = (kortti.getRivi() + 1);
        int sarake = (kortti.getSarake() - 1);

        Kortti vasenKortti = this.alusta.valitseKortti(rivi, sarake);

        return vasenKortti;
    }

    /**
     * Hakee kortille tallennettujen rivin ja sarakkeen perusteella alaoikealla
     * olevan kortin
     *
     * @param kortti Tarkasteltava kortti
     * @return alaoikealla oleva kortti
     */
    public Kortti haeAlaOikeaKortti(Kortti kortti) {
        int rivi = (kortti.getRivi() + 1);
        int sarake = (kortti.getSarake() + 1);

        Kortti oikeaKortti = this.alusta.valitseKortti(rivi, sarake);

        return oikeaKortti;
    }

}
