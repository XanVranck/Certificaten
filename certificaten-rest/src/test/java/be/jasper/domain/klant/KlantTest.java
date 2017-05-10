package be.jasper.domain.klant;

import org.junit.Test;
import org.springframework.core.annotation.Order;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xanv on 9/05/2017.
 */
public class KlantTest {
    @Test
    public void createKlant_getNaam_ShouldReturnXan() throws Exception {
        Klant klant = new Klant("Xan", new Adres("Schoolstraat", "78", "1745", "Opwijk"));

        assertThat(klant.getNaam()).isEqualTo("Xan");
    }

    
    @Test
    public void createKlant_getAdresShouldReturnAdres() throws Exception {
        Adres adres = new Adres("Schoolstraat", "78", "1745", "Opwijk");
        Klant klant = new Klant("Xan", adres);

        assertThat(klant.getAdres()).isEqualTo(adres);
    }
}
