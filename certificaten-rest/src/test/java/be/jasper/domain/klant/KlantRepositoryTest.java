package be.jasper.domain.klant;

import be.jasper.infrastructure.SpringIntegrationTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xanv on 10/05/2017.
 */
public class KlantRepositoryTest extends SpringIntegrationTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private KlantRepository klantRepository;

    @Inject
    private KlantService klantService;

    private Klant xan, nena;


    @Before
    public void setUp() throws Exception {
        xan = new Klant("Xan");
        nena = new Klant("Nena");

       klantService.addKlant(xan);
       klantService.addKlant(nena);
    }

    @Test
    public void addKlant() throws Exception {
        Klant jasper = new Klant("Jasper");

        klantService.addKlant(jasper);

        assertThat(klantRepository.getKlanten()).contains(xan, nena, jasper);
    }

    @Test
    public void getKlantByNaam_ShouldReturn_Klant() throws Exception {
        assertThat(klantRepository.findKlantByNaam("Xan")).isEqualTo(xan);
    }

    @Test
    public void addKlant_getKlantByNaam_ShouldReturnKlant() throws Exception {
        Klant jasper = new Klant("Jasper");

        klantService.addKlant(jasper);

        assertThat(klantRepository.findKlantByNaam("Jasper")).isEqualTo(jasper);

    }

    @Test
    public void getKlantByNaam_ShouldReturn_Nena() throws Exception {
        assertThat(klantRepository.findKlantByNaam("Nena")).isEqualTo(nena);
    }

    @Test
    public void getKlanten() throws Exception {
        assertThat(klantRepository.getKlanten()).contains(xan, nena);
    }

    @After
    public void tearDown() throws Exception {
        entityManager.clear();
    }
}