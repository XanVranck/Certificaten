package be.jasper.domain.klant;

import be.jasper.controller.KlantDTO;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class KlantFactory {
    @Inject
    private KlantService klantService;

    public KlantFactory() {
    }

    public Klant createKlant(KlantDTO klant) {
        return new Klant(klant.getNaam());
    }
}
