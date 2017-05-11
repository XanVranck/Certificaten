package be.jasper.domain.klant;

import be.jasper.domain.order.Order;
import org.junit.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xanv on 9/05/2017.
 */
public class KlantTest {
    @Inject
    private Klant klant;

    @Inject
    private Order order;

    @Test
    public void createKlant_getNaam_ShouldReturnXan() throws Exception {
        klant = new Klant("Xan", new Adres("Schoolstraat", "78", "1745", "Opwijk"));

        assertThat(klant.getNaam()).isEqualTo("Xan");
    }


    @Test
    public void createKlant_getAdresShouldReturnAdres() throws Exception {
        Adres adres = new Adres("Schoolstraat", "78", "1745", "Opwijk");
        klant = new Klant("Xan", adres);

        assertThat(klant.getAdres()).isEqualTo(adres);
    }

    @Test
    public void addOrder() throws Exception {
        klant = new Klant();
        order = new Order();

        klant.addOrder(order);

        assertThat(klant.getOrders()).contains(order);
    }
}
