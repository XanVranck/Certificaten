package be.jasper.controller;

import be.jasper.infrastructure.SpringIntegrationTest;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class KlantControllerTest  extends SpringIntegrationTest {
    private KlantDTO nenaDTO;
    private List<KlantDTO> klantDTOList= new ArrayList<>();

    @Inject
    private KlantController klantController;

    @Before
    public void setUp() throws Exception {
        nenaDTO = new KlantDTO(1, "Nena");
        klantDTOList.add(nenaDTO);
    }

    @Test
    public void addKlantEnGetKlant_ZouJuistToegevoegdeKlantMoetenTerugGeven() throws Exception {
        klantController.addKlant(nenaDTO);
        assertThat(klantController.getKlanten().toString()).isEqualTo(klantDTOList.toString());
    }

}