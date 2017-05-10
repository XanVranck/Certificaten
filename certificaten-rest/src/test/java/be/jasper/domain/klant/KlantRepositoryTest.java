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
    private Adres adresXan, adresNena;

    private AdresTestBuilder adresTestBuilder = new AdresTestBuilder();

    //TODO: save adres in DB!
    @Before
    public void setUp() throws Exception {
        adresXan = adresTestBuilder.build();
        adresNena = adresTestBuilder
                .withStraat("Bremenhulleken")
                .withNummer("8")
                .withPostCode("9200")
                .withStad("Lebbeke")
                .build();
        xan = new Klant("Xan", adresXan);
        nena = new Klant("Nena", adresNena);

       klantService.addKlant(xan);
       klantService.addKlant(nena);
    }

    @Test
    public void addKlant() throws Exception {
        Adres adresJasper = adresTestBuilder
                .withStraat("AntwerpenStraat")
                .withNummer("25")
                .withPostCode("2000")
                .withStad("Antwerpen")
                .build();
        Klant jasper = new Klant("Jaspe", adresJasper);

        klantService.addKlant(jasper);

        assertThat(klantRepository.getKlanten()).containsExactly(xan, nena, jasper);
    }

    @Test
    public void getKlanten() throws Exception {
        assertThat(klantRepository.getKlanten()).containsExactly(xan, nena);
    }

    @After
    public void tearDown() throws Exception {
        entityManager.clear();
    }
}