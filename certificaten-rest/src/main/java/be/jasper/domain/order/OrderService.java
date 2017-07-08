package be.jasper.domain.order;

import be.jasper.controller.OrderDTO;
import be.jasper.domain.certificaat.Certificaat;
import be.jasper.domain.klant.Klant;
import be.jasper.domain.klant.KlantRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class OrderService {
    @Inject
    private OrderFactory orderFactory;

    @Inject
    private KlantRepository klantRepository;

    @Inject
    private OrderRepository orderRepository;

    public void addOrder(OrderDTO order){
        Klant klant = klantRepository.findKlantByNaam(order.getKlantNaam());

        klant.addOrder(orderFactory.createOrder(order));
    }

    public List<Order> getOrders(){
        return orderRepository.getOrders();
    }

    public Order findOrderById(int orderId) {
        return orderRepository.findOrder(orderId);
    }

    public List<Certificaat> getCertificaten(Order order) {
        return order.getCertificaten();
    }

    public void addCertificaat(Order order, Certificaat certificaat) {
       order.addCertificaat(certificaat);
    }
}
