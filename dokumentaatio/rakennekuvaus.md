#Rakennekuvaus#

Ohjelma koostuu graafisesta käyttöliittymästä ja neljästä pelilogiikkaluokasta, Pelilogiikka, Kasi, Noppa, Laskuri. Käyttöliittymä mahdollistaa noppien heittämisen ja valitsemisen sekä pistesarakkeiden valitsemisen.

Pelilogiikka tarjoaa metodit käyttöliittymästä tulevien pyyntöjen käsittelyyn. Pelilogiikalla on oliomuuttujina Käsi-olio ja Laskuri-olio. Käsi sisältää viisi Noppa-oliota sisältävän listan ja metodit noppien käsittelyyn, kuten kaikkien tai osan nopista heittämisen. Noppa-olioilla on arvo, joka on väliltä 1...6, arpoja, sekä tieto siitä onko noppa valittuna vai ei. Noppa tarjoaa metodit valittu-muutujan muuttamiseen ja arvon arpomiseen. Noppa kuvastaa siis yksittäistä noppaa.

Laskurilla on lista, jonka indeksit kuvastavat tulostaulukon sarakkeita. Kullekin sarakkeelle on oma laskukaava, jonka perusteella Laskuri tallentaa pisteet kyseiseen sarakkeeseen. Laskurilla on tiedossaan myös Pelilogiikan Käsi, sillä pisteytys perustuu noppien silmälukuihin. Pelilogiikka välittää Laskurille tiedon valitusta sarakkeesta ja Laskuri prosessoi ja tallentaa tiedon. Laskuri päivittää aina pistelisäyksen yhteydessä summan ja välisumman.
