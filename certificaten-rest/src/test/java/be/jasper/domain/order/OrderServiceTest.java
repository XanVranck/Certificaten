package be.jasper.domain.order;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Matchers.refEq;
import static org.mockito.Mockito.verify;

public class OrderServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void addOrder() throws Exception {
        Order order = new Order("5252", "sqdqsd", "durp", 20);
        orderRepository.addOrder(order);
        verify(orderRepository).addOrder(refEq(order));
    }

    @Test
    public void getOrders() throws Exception {
        orderService.getOrders();
        verify(orderRepository).getOrders();
    }
}


