package be.jasper.domain.klant;

import be.jasper.controller.KlantDTO;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class KlantService {
    @Inject
    private KlantRepository klantRepository;

    @Inject
    private KlantDTO klantDTO;

    public void addKlant(Klant klant) {
        klantRepository.addKlant(klant);
    }

    public List<Klant> getKlanten() {
        return klantRepository.getKlanten();
    }

    public Klant findKlantById(int id) {
        return klantRepository.findKlantById(id);
    }

    public List<KlantDTO> getKlantenDTO() {
        return klantRepository.getKlanten()
                .stream()
                .map(klant -> new KlantDTO(klant.getKlantID(), klant.getNaam()))
                .collect(Collectors.toList());
    }
}
