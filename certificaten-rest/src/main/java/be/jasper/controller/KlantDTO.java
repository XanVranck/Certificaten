package be.jasper.controller;

/**
 * Created by xanv on 16/05/2017.
 */
public class KlantDTO {
    private int klantId;
    private String naam;

    public KlantDTO(int klantId, String naam) {
        this.klantId = klantId;
        this.naam = naam;
    }

    public int getKlantId() {
        return klantId;
    }

    public String getNaam() {
        return naam;
    }

    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
