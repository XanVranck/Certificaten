package be.jasper.domain.klant;

import be.jasper.controller.KlantDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by xanv on 13/07/2017.
 */
public class KlantFactoryTest {

    private KlantFactory klantFactory = new KlantFactory();

    @Test
    public void createKlant_ShouldReturnKlant() throws Exception {
        KlantDTO klantDTO = new KlantDTO(1,"Xan");
        Klant klant = new Klant("Xan");

        Assertions.assertThat(klantFactory.createKlant(klantDTO)).isEqualTo(klant);
    }

}