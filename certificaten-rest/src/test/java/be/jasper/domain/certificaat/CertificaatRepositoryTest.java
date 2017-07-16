package be.jasper.domain.certificaat;

import be.jasper.infrastructure.SpringIntegrationTest;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class CertificaatRepositoryTest extends SpringIntegrationTest {
    private Certificaat certificaat = new Certificaat("nummer", new Date(), 555);

    @Inject
    private CertificaatRepository certificaatRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {
        entityManager.persist(certificaat);
    }

    @Test
    public void findCertificaatById() throws Exception {
        assertThat(certificaatRepository.findCertificaatById(1)).isEqualTo(certificaat);
    }

}