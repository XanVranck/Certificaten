package be.jasper.domain.order;

import be.jasper.controller.OrderDTO;

/**
 * Created by xanv on 11/05/2017.
 */
public class OrderFactory {
    public OrderFactory() {
    }

    public Order createOrder(OrderDTO order) {
        return new Order(order.getWerkOrderNummer(), order.getAankoopOrderNummer(), order.getSpecificatie(), order.getTotaal());
    }
}
