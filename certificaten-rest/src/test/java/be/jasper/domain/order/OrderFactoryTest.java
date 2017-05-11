package be.jasper.domain.order;

import be.jasper.controller.OrderDTO;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderFactoryTest {

    public static final String WORK_ORDER_NUMBER = "01e12a";
    public static final String PURCHASE_ORDER_NUMBER = "665452BD";
    public static final String SPECIFICATION = "specification";
    public static final int TOTAL = 5000;
    public static final int CUSTOMER_ID = 5;

    @Test
    public void createOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO(WORK_ORDER_NUMBER, PURCHASE_ORDER_NUMBER, SPECIFICATION, TOTAL, CUSTOMER_ID);

        Order order = new OrderFactory().createOrder(orderDTO);

        assertThat(order).isEqualToComparingFieldByField(new Order(WORK_ORDER_NUMBER, PURCHASE_ORDER_NUMBER, SPECIFICATION, TOTAL));
    }
}
