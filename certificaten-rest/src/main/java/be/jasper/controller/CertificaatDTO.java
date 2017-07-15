package be.jasper.controller;

import java.util.Date;

/**
 * Created by xanv on 11/05/2017.
 */
public class CertificaatDTO {
    private Integer orderID;
    private String certificaatNummer;
    private Date certificaatDatum;
    private int specifiekTonnage;

    public CertificaatDTO() {
    }

    public CertificaatDTO(Integer orderID, String certificaatNummer, Date certificaatDatum, int specifiekTonnage) {
        this.orderID = orderID;
        this.certificaatNummer = certificaatNummer;
        this.certificaatDatum = certificaatDatum;
        this.specifiekTonnage = specifiekTonnage;
    }

    public String getCertificaatNummer() {
        return certificaatNummer;
    }

    public Date getCertificaatDatum() {
        return certificaatDatum;
    }

    public Integer getSpecifiekTonnage() {
        return specifiekTonnage;
    }

    public Integer getOrderId() {
        return orderID;
    }

    public void setCertificaatNummer(String certificaatNummer) {
        this.certificaatNummer = certificaatNummer;
    }

    public void setCertificaatDatum(Date certificaatDatum) {
        this.certificaatDatum = certificaatDatum;
    }

    public void setSpecifiekTonnage(int specifiekTonnage) {
        this.specifiekTonnage = specifiekTonnage;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "CertificaatDTO{" +
                "orderID=" + orderID +
                ", certificaatNummer='" + certificaatNummer + '\'' +
                ", certificaatDatum=" + certificaatDatum +
                ", specifiekTonnage=" + specifiekTonnage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CertificaatDTO that = (CertificaatDTO) o;

        if (specifiekTonnage != that.specifiekTonnage) return false;
        if (orderID != null ? !orderID.equals(that.orderID) : that.orderID != null) return false;
        if (certificaatNummer != null ? !certificaatNummer.equals(that.certificaatNummer) : that.certificaatNummer != null)
            return false;
        return certificaatDatum != null ? certificaatDatum.equals(that.certificaatDatum) : that.certificaatDatum == null;
    }

    @Override
    public int hashCode() {
        int result = orderID != null ? orderID.hashCode() : 0;
        result = 31 * result + (certificaatNummer != null ? certificaatNummer.hashCode() : 0);
        result = 31 * result + (certificaatDatum != null ? certificaatDatum.hashCode() : 0);
        result = 31 * result + specifiekTonnage;
        return result;
    }
}
