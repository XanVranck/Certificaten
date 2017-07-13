package be.jasper.domain.klant;

import be.jasper.controller.KlantDTO;
import be.jasper.controller.OrderDTO;
import be.jasper.domain.order.Order;
import be.jasper.errorhandler.KlantNietGevonden;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KlantService {
    @Inject
    private KlantRepository klantRepository;

    @Inject
    private KlantFactory klantFactory;

    public void addKlant(KlantDTO klantDTO) {
        Klant klant = klantFactory.createKlant(klantDTO);
        klantRepository.addKlant(klant);
    }

    public List<Klant> getKlanten() {
        return klantRepository.getKlanten();
    }

    public Klant findKlantByNaam(String naam) throws KlantNietGevonden {
            return klantRepository.findKlantByNaam(naam);
    }

    public List<KlantDTO> getKlantenDTO() {
        return klantRepository.getKlanten()
                .stream()
                .map(klant -> new KlantDTO(klant.getKlantID(), klant.getNaam()))
                .collect(Collectors.toList());
    }

    public List<OrderDTO> getOrders(Klant klant) {
        return klant.getOrders()
                .stream()
                .map(order -> new OrderDTO(order.getOrderID(), order.getWerkOrderNummer(), order.getAankoopOrderNummer(), order.getSpecificatie(), order.getTotaal(), klant.getNaam()))
                .collect(Collectors.toList());

    }

    public void addOrder(Klant klant, Order order) {
        klant.addOrder(order);
    }
}
