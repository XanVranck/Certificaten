package be.jasper.domain.certificaat;

import be.jasper.infrastructure.SpringIntegrationTest;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CertificaatRepositoryTest extends SpringIntegrationTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private CertificaatRepository certificaatRepository;

    private Certificaat one, two;

    @Before
    public void setup() {
        one = new Certificaat("1", "1",50);
        two = new Certificaat("3", "1", 79);
        entityManager.persist(one);
        entityManager.persist(two);
    }

    @Test
    public void addCertificaat() throws Exception {
        Certificaat certificaat = new Certificaat("2", "1", 6541);
        certificaatRepository.addCertificaat(certificaat);
        Assertions.assertThat(certificaatRepository.getCertificaten()).contains(one, two, certificaat);
    }

    @Test
    public void getKlanten() throws Exception {
        Assertions.assertThat(certificaatRepository.getCertificaten()).contains(one, two);
    }

    @After
    public void cleanDatabase() {
        entityManager.clear();
    }

}
