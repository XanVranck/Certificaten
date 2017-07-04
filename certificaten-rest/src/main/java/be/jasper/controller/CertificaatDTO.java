package be.jasper.controller;

/**
 * Created by xanv on 11/05/2017.
 */
public class CertificaatDTO {
    private int orderID;
    private String certificaatNummer;
    private String certificaatDatum;
    private int specifiekTonnage;

    public CertificaatDTO(int orderID, String certificaatNummer, String certificaatDatum, int specifiekTonnage) {
        this.orderID = orderID;
        this.certificaatNummer = certificaatNummer;
        this.certificaatDatum = certificaatDatum;
        this.specifiekTonnage = specifiekTonnage;
    }

    public String getCertificaatNummer() {
        return certificaatNummer;
    }

    public String getCertificaatDatum() {
        return certificaatDatum;
    }

    public int getSpecifiekTonnage() {
        return specifiekTonnage;
    }

    public int getOrderId() {
        return orderID;
    }

    public void setCertificaatNummer(String certificaatNummer) {
        this.certificaatNummer = certificaatNummer;
    }

    public void setCertificaatDatum(String certificaatDatum) {
        this.certificaatDatum = certificaatDatum;
    }

    public void setSpecifiekTonnage(int specifiekTonnage) {
        this.specifiekTonnage = specifiekTonnage;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

}
