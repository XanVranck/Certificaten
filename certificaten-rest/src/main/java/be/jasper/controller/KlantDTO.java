package be.jasper.controller;

public class KlantDTO {
    private int klantId;
    private String naam;

    public KlantDTO(int klantId, String naam) {
        this.klantId = klantId;
        this.naam = naam;
    }

    public KlantDTO() {
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

    @Override
    public String toString() {
        return "KlantDTO{" +
                "klantId=" + klantId +
                ", naam='" + naam + '\'' +
                '}';
    }
}
