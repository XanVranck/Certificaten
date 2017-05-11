package be.jasper.domain.order;

import be.jasper.controller.OrderDTO;
import be.jasper.domain.klant.Klant;
import be.jasper.domain.klant.KlantRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class OrderService {
    @Inject
    private OrderFactory orderFactory;

    @Inject
    private KlantRepository klantRepository;

    @Inject
    private OrderRepository orderRepository;

    public void addOrder(OrderDTO order){
        Klant klant = klantRepository.findKlantById(order.getKlantId());

        klant.addOrder(orderFactory.createOrder(order));
    }

    public List<Order> getOrders(){
        return orderRepository.getOrders();
    }

}
