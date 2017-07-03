package be.jasper.domain.klant;

import be.jasper.controller.KlantDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
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

    public Klant findKlantByNaam(String naam) {
        return klantRepository.findKlantByNaam(naam);
    }

    public List<KlantDTO> getKlantenDTO() {
        return klantRepository.getKlanten()
                .stream()
                .map(klant -> new KlantDTO(klant.getKlantID(), klant.getNaam()))
                .collect(Collectors.toList());
    }
}
