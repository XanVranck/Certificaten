package be.jasper.errorhandler;

public class KlantNietGevonden extends RuntimeException {

    public KlantNietGevonden(String klantNaam){
        super(klantNaam + " niet gevonden in de databank, geef een juiste klant in");
    }
}
