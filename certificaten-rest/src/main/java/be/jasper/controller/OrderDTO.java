package be.jasper.controller;

/**
 * Created by xanv on 11/05/2017.
 */
public class OrderDTO {
    private int orderId;
    private String werkOrderNummer;
    private String aankoopOrderNummer;
    private String specificatie;
    private int totaal;
    private String klantNaam;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, String werkOrderNummer, String aankoopOrderNummer, String specificatie, int totaal, String klantNaam) {
        this.orderId = orderId;
        this.werkOrderNummer = werkOrderNummer;
        this.aankoopOrderNummer = aankoopOrderNummer;
        this.specificatie = specificatie;
        this.totaal = totaal;
        this.klantNaam = klantNaam;
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

    public String getKlantNaam() {
        return klantNaam;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setKlantNaam(String klantNaam) {
        this.klantNaam = klantNaam;
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

}
