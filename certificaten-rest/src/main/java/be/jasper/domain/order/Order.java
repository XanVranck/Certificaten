package be.jasper.domain.order;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int orderID;

    @Column(name = "WERK_ORDER_NUMMER", unique = true)
    private String werkOrderNummer;

    @Column(name = "AANKOOP_ORDER_NUMMER")
    private String aankoopOrderNummer;

    @Column(name = "SPECIFICATIE")
    private String specificatie;

    @Column(name = "TOTAAL")
    private int totaal;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Certificaat> certificaten = new ArrayList<>();

    public Order() {
    }

    public Order(String werkOrderNummer, String aankoopOrderNummer, String specificatie, int totaal) {
        this.werkOrderNummer = werkOrderNummer;
        this.aankoopOrderNummer = aankoopOrderNummer;
        this.specificatie = specificatie;
        this.totaal = totaal;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getWerkOrderNummer() {
        return werkOrderNummer;
    }

    public String getAankoopOrderNummer() {
        return aankoopOrderNummer;
    }

    public String getSpecificatie() {
        return specificatie;
    }

    public int getTotaal() {
        return totaal;
    }

//    public void addCertificaat(Certificaat certificaat) {
//        certificaten.add(certificaat);
//    }
//
//
//    public List<Certificaat> getCertificaten() {
//        return certificaten;
//    }
}
