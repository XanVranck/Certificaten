package be.jasper.domain.certificaat;

import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CERTIFICATEN")
public class Certificaat {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "CERTIFICAAT_ID")
    private int certificaatID;

    @Column(name = "CERTIFICAAT_NUMMER", unique = true)
    private String certificaatNummer;

    @Column(name = "CERTIFICAAT_DATUM")
    @Type(type="date")
    private Date certificaatDatum;

    @Column(name = "SPECIFIEK_TONNAGE")
    private int specifiekTonnage;

    public Certificaat(String certificaatNummer, Date certificaatDatum, int specifiekGewicht) {
        this.certificaatNummer = certificaatNummer;
        this.certificaatDatum = certificaatDatum;
        this.specifiekTonnage = specifiekGewicht;
    }

    public Certificaat() {
    }

    public int getCertificaatID() {
        return certificaatID;
    }

    public String getCertificaatNummer() {
        return certificaatNummer;
    }

    public Date getCertificaatDatum() {
        return certificaatDatum;
    }

    public int getSpecifiekTonnage() {
        return specifiekTonnage;
    }

    @Override
    public String toString() {
        return "Certificaat{" +
                "certificaatID=" + certificaatID +
                ", certificaatNummer='" + certificaatNummer + '\'' +
                ", certificaatDatum=" + certificaatDatum +
                ", specifiekTonnage=" + specifiekTonnage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Certificaat that = (Certificaat) o;

        if (certificaatID != that.certificaatID) return false;
        if (specifiekTonnage != that.specifiekTonnage) return false;
        if (certificaatNummer != null ? !certificaatNummer.equals(that.certificaatNummer) : that.certificaatNummer != null)
            return false;
        return certificaatDatum != null ? certificaatDatum.equals(that.certificaatDatum) : that.certificaatDatum == null;
    }

    @Override
    public int hashCode() {
        int result = certificaatID;
        result = 31 * result + (certificaatNummer != null ? certificaatNummer.hashCode() : 0);
        result = 31 * result + (certificaatDatum != null ? certificaatDatum.hashCode() : 0);
        result = 31 * result + specifiekTonnage;
        return result;
    }
}
