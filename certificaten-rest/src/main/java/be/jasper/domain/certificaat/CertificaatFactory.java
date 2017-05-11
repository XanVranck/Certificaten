package be.jasper.domain.certificaat;

import be.jasper.controller.CertificaatDTO;

import javax.inject.Named;

@Named
public class CertificaatFactory {
    public CertificaatFactory() {
    }

    public Certificaat createCertificaat(CertificaatDTO certificaat){
        return new Certificaat(certificaat.getCertificaatNummer(), certificaat.getCertificaatDatum(), certificaat.getSpecifiekTonnage());
    }
}
