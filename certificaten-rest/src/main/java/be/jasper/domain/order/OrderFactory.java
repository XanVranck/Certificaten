package be.jasper.domain.order;

import be.jasper.controller.OrderDTO;

import javax.inject.Named;

@Named
public class OrderFactory {
    public OrderFactory() {
    }

    public Order createOrder(OrderDTO order) {
        return new Order(order.getWerkOrderNummer(), order.getAankoopOrderNummer(), order.getSpecificatie(), order.getTotaal());
    }
}
