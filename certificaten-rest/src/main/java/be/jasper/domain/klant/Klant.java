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
}
