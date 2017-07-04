package be.jasper.controller;

import be.jasper.domain.klant.Klant;
import be.jasper.infrastructure.SpringIntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


public class KlantControllerTest  extends SpringIntegrationTest {
    private Klant nena;
    private KlantDTO nenaDTO;
    private List<KlantDTO> klantDTOList= new ArrayList<>();

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private KlantController klantController;

    @Before
    public void setUp() throws Exception {
        nena = new Klant("Nena");
        nenaDTO = new KlantDTO(1, "Nena");
        klantDTOList.add(nenaDTO);
        klantController.addKlant(nena);
    }

    @Test
    public void addKlantEnGetKlant_ZouJuistToegevoegdeKlantMoetenTerugGeven() throws Exception {
        Assertions.assertThat(klantController.getKlanten().toString()).isEqualTo(klantDTOList.toString());
    }

}