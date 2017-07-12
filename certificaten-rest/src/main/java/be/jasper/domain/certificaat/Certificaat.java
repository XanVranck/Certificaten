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
}
