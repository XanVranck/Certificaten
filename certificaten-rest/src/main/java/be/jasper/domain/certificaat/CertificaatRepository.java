package be.jasper.domain.certificaat;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CertificaatRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Certificaat findCertificaatById(int certificaatId) {
            return entityManager.find(Certificaat.class, certificaatId);
    }

    public void deleteCertificaat(Certificaat certificaat) {
        entityManager.remove(certificaat);
    }
}
