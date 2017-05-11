package be.jasper.domain.certificaat;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

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
    private String certificaatDatum;

    @Column(name = "SPECIFIEK_TONNAGE")
    private int specifiekTonnage;

    public Certificaat(String certificaatNummer, String certificaatDatum, int specifiekGewicht) {
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

    public String getCertificaatDatum() {
        return certificaatDatum;
    }

    public int getSpecifiekTonnage() {
        return specifiekTonnage;
    }
}
