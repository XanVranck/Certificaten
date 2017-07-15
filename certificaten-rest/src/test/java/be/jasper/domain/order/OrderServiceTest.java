package be.jasper.domain.order;

import be.jasper.controller.OrderDTO;
import be.jasper.infrastructure.SpringIntegrationTest;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Inject;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.verify;

public class OrderServiceTest extends SpringIntegrationTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private OrderService orderServiceInjectMocks;

    @Mock
    private OrderRepository orderRepositoryMock;

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private OrderService orderService;

    @Test
    public void addOrder_verwijstNaarOrderRepo() throws Exception {
        Order order = new Order("5252", "sqdqsd", "durp", 20);
        orderRepositoryMock.addOrder(order);
        verify(orderRepositoryMock).addOrder(refEq(order));
    }

    @Test
    public void getOrders_verwijstNaarOrderRepo() throws Exception {
        orderServiceInjectMocks.getOrders();
        verify(orderRepositoryMock).getOrders();
    }

    @Test
    public void updateOrder_shouldUpdateOrder() throws Exception {
        Order order = new Order("won","aon", "spec", 200);
        orderRepository.addOrder(order);
        OrderDTO orderDTO = new OrderDTO(1,"werkOrder", "aankoop", "spec", 200, "Xan");
        orderService.updateOrder(1, orderDTO);

        assertThat(order.getWerkOrderNummer()).isEqualTo("werkOrder");
    }
}


