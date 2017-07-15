package be.jasper.controller;

import be.jasper.errorhandler.KlantNietGevonden;
import be.jasper.infrastructure.SpringIntegrationTest;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderControllerTest extends SpringIntegrationTest {
    private List<OrderDTO> orderDTOList = new ArrayList<>();
    private KlantDTO nenaDTO;
    private OrderDTO orderDTO;

    @Inject
    private KlantController klantController;
    @Inject
    private OrderController orderController;

    @Before
    public void setUp() throws Exception {
        nenaDTO = new KlantDTO(1, "Nena");
        orderDTO = new OrderDTO(1, "werkOrderNummer", "aankoopOrderNummer", "Specificatie", 200, "Nena");
        orderDTOList.add(orderDTO);
    }

    @Test
    public void addOrderToKlant_ReturnsOrder() throws Exception {
        klantController.addKlant(nenaDTO);
        orderController.addOrder(orderDTO);
        assertThat(orderController.getOrders("Nena")).isEqualTo(orderDTOList);
    }

    @Test
    public void addOrderToKlant_NonExistingKlant_ThrowsKlantNietGekendException() throws Exception {
        klantController.addKlant(nenaDTO);
        orderController.addOrder(orderDTO);
        assertThatThrownBy(() -> orderController.getOrders("Derp")).isInstanceOf(KlantNietGevonden.class)
                .hasMessage("Derp niet gevonden in de databank, geef een juiste klant in")
                .hasNoCause();
    }
}