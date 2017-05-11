package be.jasper.domain.klant;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class KlantRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addKlant(Klant klant) {
        entityManager.persist(klant);
    }

    public void addAdres(Adres adres) {
        entityManager.persist(adres);
    }

    public List<Klant> getKlanten() {
        return entityManager.createQuery("select k from Klant k", Klant.class).getResultList();
    }

    public Klant findKlantById(int klantId){
        return entityManager.find(Klant.class, klantId);
    }
}
