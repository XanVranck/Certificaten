package be.jasper.controller;

import java.util.Date;

public class CertificaatIdDTO {
    private int certificaatId;
    private String certificaatNummer;
    private Date certificaatDatum;
    private int specifiekTonnage;

    public CertificaatIdDTO() {
    }

    public CertificaatIdDTO(int certificaatId, String certificaatNummer, Date certificaatDatum, int specifiekTonnage) {
        this.certificaatId = certificaatId;
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


    public int getCertificaatId() {
        return certificaatId;
    }

    public void setCertificaatId(int certificaatId) {
        this.certificaatId = certificaatId;
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

    @Override
    public String toString() {
        return "CertificaatIdDTO{" +
                "certificaatId=" + certificaatId +
                ", certificaatNummer='" + certificaatNummer + '\'' +
                ", certificaatDatum=" + certificaatDatum +
                ", specifiekTonnage=" + specifiekTonnage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CertificaatIdDTO that = (CertificaatIdDTO) o;

        if (certificaatId != that.certificaatId) return false;
        if (specifiekTonnage != that.specifiekTonnage) return false;
        if (certificaatNummer != null ? !certificaatNummer.equals(that.certificaatNummer) : that.certificaatNummer != null)
            return false;
        return certificaatDatum != null ? certificaatDatum.equals(that.certificaatDatum) : that.certificaatDatum == null;
    }

    @Override
    public int hashCode() {
        int result = certificaatId;
        result = 31 * result + (certificaatNummer != null ? certificaatNummer.hashCode() : 0);
        result = 31 * result + (certificaatDatum != null ? certificaatDatum.hashCode() : 0);
        result = 31 * result + specifiekTonnage;
        return result;
    }
}
