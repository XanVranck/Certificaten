package be.jasper.domain.klant;

import javax.inject.Named;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ADRES")
@Named
public class Adres {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ADRES_ID")
    private  int adresID;

    @Column(name = "STRAAT")
    private String straat;

    @Column(name = "NUMMER")
    private String nummer;

    @Column(name = "POSTCODE")
    private String postCode;

    @Column(name = "STAD")
    private String stad;

    public Adres(String straat, String nummer, String postCode, String stad) {
        this.straat = straat;
        this.nummer = nummer;
        this.postCode = postCode;
        this.stad = stad;
    }

    public Adres() {
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
}
