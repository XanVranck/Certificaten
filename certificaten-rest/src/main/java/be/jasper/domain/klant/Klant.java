package be.jasper.domain.klant;

import javax.persistence.*;

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
    @JoinColumn(name = "FK_ADRES_ID")
    private Adres adres;


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
}
