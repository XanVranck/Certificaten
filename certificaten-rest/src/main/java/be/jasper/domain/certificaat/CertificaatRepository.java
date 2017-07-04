package be.jasper.domain.certificaat;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CertificaatRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void addCertificaat(Certificaat certificaat) {
        entityManager.persist(certificaat);
    }

    public List<Certificaat> getCertificaten() {
        return entityManager.createQuery("select c from Certificaat c", Certificaat.class).getResultList();
    }
}
