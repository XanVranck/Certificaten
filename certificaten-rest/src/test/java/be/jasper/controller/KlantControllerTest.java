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


public class KlantControllerTest extends SpringIntegrationTest {
    private KlantDTO nenaDTO;
    private List<KlantDTO> klantDTOList = new ArrayList<>();

    @Inject
    private KlantController klantController;

    @Before
    public void setUp() throws Exception {
        nenaDTO = new KlantDTO(1, "Nena");
        klantDTOList.add(nenaDTO);
        klantController.addKlant(nenaDTO);
    }

    @Test
    public void addKlantEnGetKlant_ZouJuistToegevoegdeKlantMoetenTerugGeven() throws Exception {
        assertThat(klantController.getKlanten().toString()).isEqualTo(klantDTOList.toString());
    }

    @Test
    public void deleteKlant_noKlantenLeft() throws Exception {
        klantController.deleteKlant(nenaDTO);

        assertThat(klantController.getKlanten()).isEmpty();
    }

    @Test
    public void deleteKlant_klantNietInDeDBThrowsKlantNietGevonden() throws Exception {
        assertThatThrownBy(()->klantController.deleteKlant(new KlantDTO(5,"BS"))).isInstanceOf(KlantNietGevonden.class);
    }
}