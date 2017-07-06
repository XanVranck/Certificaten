package be.jasper.domain.klant;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class KlantRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addKlant(Klant klant) {
        entityManager.persist(klant);
    }

    public List<Klant> getKlanten() {
        return entityManager.createQuery("select k from Klant k", Klant.class).getResultList();
    }

    public Klant findKlantById(int id) {
        Query query = entityManager.createQuery("select k FROM Klant k WHERE klantId=:id");
        query.setParameter("id", id);
        return (Klant) query.getSingleResult();
    }

    public Klant findKlantByNaam(String naam) {
        Query query = entityManager.createQuery("select k FROM Klant k WHERE naam=:naam");
        query.setParameter("naam", naam);
        return (Klant) query.getSingleResult();
    }


}
