package be.jasper.domain.order;

import be.jasper.controller.CertificaatDTO;
import be.jasper.controller.OrderDTO;
import be.jasper.domain.certificaat.Certificaat;
import be.jasper.domain.klant.Klant;
import be.jasper.domain.klant.KlantRepository;
import be.jasper.errorhandler.KlantNietGevonden;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Inject
    private OrderFactory orderFactory;

    @Inject
    private KlantRepository klantRepository;

    @Inject
    private OrderRepository orderRepository;

    public void addOrder(OrderDTO order) throws KlantNietGevonden {
        Klant klant = klantRepository.findKlantByNaam(order.getKlantNaam());

        klant.addOrder(orderFactory.createOrder(order));
    }

    public List<Order> getOrders(){
        return orderRepository.getOrders();
    }

    public Order findOrderById(int orderId) {
        return orderRepository.findOrderByID(orderId);
    }

    public List<CertificaatDTO> getCertificaten(Order order) {
        return order.getCertificaten()
                .stream()
                .map(certificaat -> new CertificaatDTO(order.getOrderID(), certificaat.getCertificaatNummer(), certificaat.getCertificaatDatum(), certificaat.getSpecifiekTonnage()))
                .collect(Collectors.toList());
    }

    public void addCertificaat(Order order, Certificaat certificaat) {
       order.addCertificaat(certificaat);
    }

    public void updateOrder(OrderDTO orderDTO) {
        Order order = findOrderById(orderDTO.getOrderId());
        order.setWerkOrderNummer(orderDTO.getWerkOrderNummer());
        order.setAankoopOrderNummer(orderDTO.getAankoopOrderNummer());
        order.setSpecificatie(orderDTO.getSpecificatie());
        order.setTotaal(orderDTO.getTotaal());
    }
}
