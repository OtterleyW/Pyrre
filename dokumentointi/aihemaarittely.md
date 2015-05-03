# Aihemäärittely

**Aihe:** Pyramidipasianssi

**Pelin kulku:**
Pelissä on 52 kortin pakka, joka jaetaan siten, että pyramidin huipuksi käännetään yksi kortti oikeinpäin. Huipun alapuolelle lisätään kuusi korttiriviä pyramidimalliin siten, että kukin kortti peittää edelliseltä riviltä kahden kortin kulmat. Kortit ovat kuvapuoli ylöspäin. Loput 24 korttia jäävät pakaksi, josta pelaaja kääntää kortteja yksitellen. Pelissä poistetaan korttiparit joiden silmälukujen summa on 13. Tavoitteena on saada kaikki kortit poistettua. Kortin voi poistaa, jos se on vapaana eli sen päällä ei ole toisia kortteja. Pelipakan saa käydä maksimissaan kolme kertaa läpi.

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot**

* Pelin aloittaminen
  - korttiparin poistaminen pöydältä
  - korttiparin poistaminen siten, että toinen kortti on pelipakassa
  - uuden kortin kääntäminen pakan päälimmäiseksi
  - uuden pelin aloittaminen


##Rakennekuvaus
Ohjelma on pyritty jakamaan selkeästi kahteen osaan - pelilogiikkaan ja käyttöliittymään. Pelilogiikan puolella oma pakkauksena löytyy "pelivälineille" ja itse logiikalle. Pakkauksesta kortit löytyy luokka Kortti, joka siis ilmentää pelin yksittäistä korttia, jolla on maa, arvo sekä paikka pelissä. Lisäksi pakkauksesta löytyy luokka Korttipakka, joka hallitsee yksittäisiä kortteja, joka sisältää esimerkiksi metodit, joiden avulla kortit sekoitetaan ja kortteja nostetaan. Logiikka pakkauksesta löytyy puolestaan Pelilogiikka luokka, joka sisältää pelin logiikkaa pyörittävät metodit. Pelisäännöt luokan avulla Pelilogiikka voi tarkistaa, eteneekö peli sääntöjen mukaan. Pelialusta taas sisältää tiedon siitä, miten kortit sijaitsevat "pelipöydällä".

Käyttöliittymän puolella luokka Käyttöliittymä vastaa graafisen käyttöliittymän näyttämisestä ja päivittämisestä. Tiedon siitä,  minkälaisia komponentteja piirretään Käyttöliittymä saa luokilta Pelikenttä ja Pelipakka. Pelikentässä on pelipöydällä sijaitsevat kortit, Pelipakassa taas luonnollisesti pakassa olevat koriti. Yksittäistä korttia kuvaa luokka KorttiButton, joka mm. vastaa siitä, mikä kuva kullakin kortilla on. Pöytäkuuntelija reagoi, kun jokin pöydällä olevista KorttiButtoneista valitaan, kun taas Pakkakuuntelija reagoi jos pelaaja valitsee Pelipakassa olevan KorttiButtonin. Pakanselaus kuuntelee, kun pelaaja haluaa selata pakan kortteja
.

