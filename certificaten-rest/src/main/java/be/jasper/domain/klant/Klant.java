package be.jasper.domain.klant;

/**
 * Created by xanv on 9/05/2017.
 */
public class Klant {
    private String naam;
    private Adres adres;

    public Klant(String naam, Adres adres) {
        this.naam = naam;
        this.adres = adres;
    }

    public String getNaam() {
        return naam;
    }

    public Adres getAdres() {
        return adres;
    }
}
