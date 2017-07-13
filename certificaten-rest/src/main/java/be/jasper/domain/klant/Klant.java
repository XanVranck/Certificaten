package be.jasper.domain.klant;

import be.jasper.domain.order.Order;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.NotFoundAction.EXCEPTION;

@Entity
@Table(name = "KLANTEN")
public class Klant {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "KLANT_ID")
    private  int klantID;

    @Column(name = "NAAM", unique = true)
    @NotFound(action = EXCEPTION)
    private String naam;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();


    public Klant(String naam) {
        this.naam = naam;
    }


    public Klant() {
    }

    public int getKlantID() {
        return klantID;
    }

    public String getNaam() {
        return naam;
    }


    public List<Order> getOrders(){
        return new ArrayList<>(orders);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klant klant = (Klant) o;

        if (klantID != klant.klantID) return false;
        if (naam != null ? !naam.equals(klant.naam) : klant.naam != null) return false;
        return orders != null ? orders.equals(klant.orders) : klant.orders == null;
    }

    @Override
    public int hashCode() {
        int result = klantID;
        result = 31 * result + (naam != null ? naam.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Klant{" +
                "klantID=" + klantID +
                ", naam='" + naam + '\'' +
                ", orders=" + orders +
                '}';
    }
}
