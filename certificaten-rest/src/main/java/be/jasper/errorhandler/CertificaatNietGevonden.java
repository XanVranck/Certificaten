package be.jasper.errorhandler;


import static java.lang.String.*;

public class CertificaatNietGevonden extends RuntimeException{

    public CertificaatNietGevonden(int certificaatId){
        super(format("Certificaat met id %d niet gevonden", certificaatId));
    }

}
