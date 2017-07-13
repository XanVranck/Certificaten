package be.jasper.domain.klant;

import be.jasper.errorhandler.KlantNietGevonden;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
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

    public Klant findKlantByNaam(String naam) throws KlantNietGevonden {
        Klant klant;
        Query query = entityManager.createQuery("select k FROM Klant k WHERE naam=:naam");
        query.setParameter("naam", naam);
        try {
            klant = (Klant) query.getSingleResult();
        } catch (NoResultException e) {
            throw new KlantNietGevonden(naam);
        }
        return klant;
    }


}
