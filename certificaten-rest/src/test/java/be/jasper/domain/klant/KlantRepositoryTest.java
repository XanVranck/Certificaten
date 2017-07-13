package be.jasper.domain.klant;

import be.jasper.controller.KlantDTO;
import be.jasper.errorhandler.KlantNietGevonden;
import be.jasper.infrastructure.SpringIntegrationTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class KlantRepositoryTest extends SpringIntegrationTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private KlantRepository klantRepository;

    @Inject
    private KlantService klantService;

    private KlantDTO xanDTO, nenaDTO;
    private Klant xan, nena;
    private Klant jasper;


    @Before
    public void setUp() throws Exception {
        xanDTO = new KlantDTO(1, "Xan");
        nenaDTO = new KlantDTO(2, "Nena");
        xan = new Klant("Xan");
        nena = new Klant("Nena");

        jasper = new Klant("Jasper");
        klantRepository.addKlant(jasper);
        klantRepository.addKlant(xan);
        klantRepository.addKlant(nena);
    }

    @Test
    public void addKlant() throws Exception {
        List<Klant> klanten = klantRepository.getKlanten();
        assertThat(klanten.get(0).getNaam()).isEqualTo("Jasper");
        assertThat(klanten.get(1).getNaam()).isEqualTo("Nena");
        assertThat(klanten.get(2).getNaam()).isEqualTo("Xan");
        assertThat(klanten).containsExactly(jasper, nena, xan);
    }

    @Test
    public void getKlantByNaam_ShouldReturn_Klant() throws Exception {
        assertThat(klantRepository.findKlantByNaam("Xan")).isEqualTo(xan);
    }

    @Test
    public void addKlant_getKlantByNaam_ShouldReturnKlant() throws Exception {
        klantRepository.addKlant(jasper);

        assertThat(klantRepository.findKlantByNaam("Jasper")).isEqualTo(jasper);

    }

    @Test
    public void getKlantByNaam_ShouldReturn_Nena() throws Exception {
        assertThat(klantRepository.findKlantByNaam("Nena")).isEqualTo(nena);
    }

    @Test
    public void getKlantByNaam_KlantNIetGevonden_ThrowKlantNietGevondenException() throws KlantNietGevonden {
        assertThatThrownBy(() -> klantRepository.findKlantByNaam("her")).isInstanceOf(KlantNietGevonden.class)
                .hasMessage("her niet gevonden in de databank, geef een juiste klant in")
                .hasNoCause();
    }

    @Test
    public void getKlanten() throws Exception {
        assertThat(klantRepository.getKlanten()).contains(jasper, nena, xan);
    }

    @After
    public void tearDown() throws Exception {
        entityManager.clear();
    }
}