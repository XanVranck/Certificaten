package be.jasper.domain.klant;

import be.jasper.domain.order.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "KLANTEN")
public class Klant {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "KLANT_ID")
    private  int klantID;

    @Column(name = "NAAM")
    private String naam;

    //TODO:moet join collum naam van collum in adres zijn, of de naam die ik wil geven?
    @OneToOne
    @JoinColumn(name = "ADRES_ID")
    private Adres adres;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();


    public Klant(String naam, Adres adres) {
        this.naam = naam;
        this.adres = adres;
    }

    public Klant() {
    }

    public String getNaam() {
        return naam;
    }

    public Adres getAdres() {
        return adres;
    }

    public List<Order> getOrders(){
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
