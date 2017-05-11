package be.jasper.domain.certificaat;

/**
 * Created by xanv on 11/05/2017.
 */
public class CertificaatTestBuilder {
    private String certificaatNummer;
    private String certificaatDatum;
    private int specifiekGewicht;

    public CertificaatTestBuilder() {
        this.certificaatNummer = "205";
        this.certificaatDatum = "17/08/1992";
        this.specifiekGewicht = 250;
    }

    public CertificaatTestBuilder withCertificaatNummer(String certificaatNummer) {
        this.certificaatNummer = certificaatNummer;
        return this;
    }

    public CertificaatTestBuilder withCertificaatDatum(String certificaatDatum) {
        this.certificaatDatum = certificaatDatum;
        return this;
    }

    public CertificaatTestBuilder withSpecifiekGewicht(int specifiekGewicht) {
        this.specifiekGewicht = specifiekGewicht;
        return this;
    }

    public Certificaat build(){
        return new Certificaat(certificaatNummer, certificaatDatum, specifiekGewicht);
    }
}
