package be.jasper.domain.klant;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class KlantService {
    @Inject
    private KlantRepository klantRepository;

    public void addKlant(Klant klant) {
        klantRepository.addKlant(klant);
    }

    public List<Klant> getKlanten() {
        return klantRepository.getKlanten();
    }

    public Klant findKlantById(int id) {
        return klantRepository.findKlantById(id);
    }
}
