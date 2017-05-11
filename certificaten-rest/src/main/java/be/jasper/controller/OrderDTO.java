package be.jasper.controller;

/**
 * Created by xanv on 11/05/2017.
 */
public class OrderDTO {
    private String werkOrderNummer;
    private String aankoopOrderNummer;
    private String specificatie;
    private int totaal;
    private int klantId;

    public OrderDTO(String werkOrderNummer, String aankoopOrderNummer, String specificatie, int totaal, int klantId) {
        this.werkOrderNummer = werkOrderNummer;
        this.aankoopOrderNummer = aankoopOrderNummer;
        this.specificatie = specificatie;
        this.totaal = totaal;
        this.klantId = klantId;
    }

    public String getWerkOrderNummer() {
        return werkOrderNummer;
    }

    public String getAankoopOrderNummer() {
        return aankoopOrderNummer;
    }

    public String getSpecificatie() {
        return specificatie;
    }

    public int getTotaal() {
        return totaal;
    }

    public int getKlantId() {
        return klantId;
    }

    public void setWerkOrderNummer(String werkOrderNummer) {
        this.werkOrderNummer = werkOrderNummer;
    }

    public void setAankoopOrderNummer(String aankoopOrderNummer) {
        this.aankoopOrderNummer = aankoopOrderNummer;
    }

    public void setSpecificatie(String specificatie) {
        this.specificatie = specificatie;
    }

    public void setTotaal(int totaal) {
        this.totaal = totaal;
    }

    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }
}
