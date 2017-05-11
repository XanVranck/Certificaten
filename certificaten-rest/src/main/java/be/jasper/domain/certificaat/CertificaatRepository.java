package be.jasper.domain.certificaat;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class CertificaatRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void addCertificate(Certificaat certificaat) {
        entityManager.persist(certificaat);
    }

    public List<Certificaat> getCertificats() {
        return entityManager.createQuery("select c from Certificaat c", Certificaat.class).getResultList();
    }
}
