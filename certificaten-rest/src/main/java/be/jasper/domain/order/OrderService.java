package be.jasper.domain.order;

import be.jasper.controller.OrderDTO;
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

}
