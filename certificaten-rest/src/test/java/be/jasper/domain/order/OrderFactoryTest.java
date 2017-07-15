package be.jasper.domain.order;

import be.jasper.controller.OrderDTO;
import be.jasper.infrastructure.SpringIntegrationTest;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderFactoryTest extends SpringIntegrationTest{

    private static final int ORDER_ID = 1;
    private static final String WORK_ORDER_NUMBER = "01e12a";
    private static final String PURCHASE_ORDER_NUMBER = "665452BD";
    private static final String SPECIFICATION = "specification";
    private static final int TOTAL = 5000;
    private static final String CUSTOMER_NAME = "Jasper";
    private Order order;

    @Before
    public void setUp() throws Exception {
        order = new Order("werkOderNummer", "aankoopOrderNummer", "specificatie", 200);
    }

    @Test
    public void createOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO(ORDER_ID, WORK_ORDER_NUMBER, PURCHASE_ORDER_NUMBER, SPECIFICATION, TOTAL, CUSTOMER_NAME);

        Order order = new OrderFactory().createOrder(orderDTO);

        assertThat(order).isEqualToComparingFieldByField(new Order(WORK_ORDER_NUMBER, PURCHASE_ORDER_NUMBER, SPECIFICATION, TOTAL));
    }

    @Test
    public void createOrderDTO() throws Exception {
        OrderDTO orderDTO = new OrderFactory().createOrderDTO(order, "Xan");

        assertThat(orderDTO.getAankoopOrderNummer()).isEqualTo(order.getAankoopOrderNummer());
        assertThat(orderDTO.getWerkOrderNummer()).isEqualTo(order.getWerkOrderNummer());
        assertThat(orderDTO.getOrderId()).isEqualTo(order.getOrderID());
        assertThat(orderDTO.getSpecificatie()).isEqualTo(order.getSpecificatie());
        assertThat(orderDTO.getTotaal()).isEqualTo(order.getTotaal());
    }
}
