package be.jasper.domain.order;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void addOrder(Order order){
        entityManager.persist(order);
    }

    public List<Order> getOrders() {
        return entityManager.createQuery("select o from Order o", Order.class).getResultList();
    }

    public Order findOrder(int orderId){
        return entityManager.find(Order.class, orderId);
    }
}
