package be.jasper.domain.order;

import be.jasper.domain.certificaat.Certificaat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Certificaat> certificaten = new ArrayList<>();

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

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setWerkOrderNummer(String werkOrderNummer) {
        this.werkOrderNummer = werkOrderNummer;
    }

    public void setAankoopOrderNummer(String aankoopOrderNummer) {
        this.aankoopOrderNummer = aankoopOrderNummer;
    }

    public void setSpecificatie(String specificatie) {
        this.specificatie = specificatie;
    }

    public void setTotaal(int totaal) {
        this.totaal = totaal;
    }

    public void setCertificaten(List<Certificaat> certificaten) {
        this.certificaten = certificaten;
    }

    public void addCertificaat(Certificaat certificaat) {
        certificaten.add(certificaat);
    }


    public List<Certificaat> getCertificaten() {
        return new ArrayList<>(certificaten);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", werkOrderNummer='" + werkOrderNummer + '\'' +
                ", aankoopOrderNummer='" + aankoopOrderNummer + '\'' +
                ", specificatie='" + specificatie + '\'' +
                ", totaal=" + totaal +
                ", certificaten=" + certificaten +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderID != order.orderID) return false;
        if (totaal != order.totaal) return false;
        if (werkOrderNummer != null ? !werkOrderNummer.equals(order.werkOrderNummer) : order.werkOrderNummer != null)
            return false;
        if (aankoopOrderNummer != null ? !aankoopOrderNummer.equals(order.aankoopOrderNummer) : order.aankoopOrderNummer != null)
            return false;
        if (specificatie != null ? !specificatie.equals(order.specificatie) : order.specificatie != null) return false;
        return certificaten != null ? certificaten.equals(order.certificaten) : order.certificaten == null;
    }

    @Override
    public int hashCode() {
        int result = orderID;
        result = 31 * result + (werkOrderNummer != null ? werkOrderNummer.hashCode() : 0);
        result = 31 * result + (aankoopOrderNummer != null ? aankoopOrderNummer.hashCode() : 0);
        result = 31 * result + (specificatie != null ? specificatie.hashCode() : 0);
        result = 31 * result + totaal;
        result = 31 * result + (certificaten != null ? certificaten.hashCode() : 0);
        return result;
    }
}
