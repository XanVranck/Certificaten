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

    public int getKlantID() {
        return klantID;
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
