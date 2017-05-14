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

    @Column(name = "STRAAT")
    private String straat;

    @Column(name = "NUMMER")
    private String nummer;

    @Column(name = "POSTCODE")
    private String postCode;

    @Column(name = "STAD")
    private String stad;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();


    public Klant(String naam, String straat, String nummer, String postCode, String stad) {
        this.naam = naam;
        this.straat = straat;
        this.nummer = nummer;
        this.postCode = postCode;
        this.stad = stad;
    }

    public String getStraat() {
        return straat;
    }

    public String getNummer() {
        return nummer;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getStad() {
        return stad;
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
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
