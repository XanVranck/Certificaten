package be.jasper.controller;

/**
 * Created by xanv on 11/05/2017.
 */
public class OrderDTO {
    private int orderId;
    private String werkOrderNummer;
    private String aankoopOrderNummer;
    private String specificatie;
    private int totaal;
    private String klantNaam;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, String werkOrderNummer, String aankoopOrderNummer, String specificatie, int totaal, String klantNaam) {
        this.orderId = orderId;
        this.werkOrderNummer = werkOrderNummer;
        this.aankoopOrderNummer = aankoopOrderNummer;
        this.specificatie = specificatie;
        this.totaal = totaal;
        this.klantNaam = klantNaam;
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

    public String getKlantNaam() {
        return klantNaam;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setKlantNaam(String klantNaam) {
        this.klantNaam = klantNaam;
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

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", werkOrderNummer='" + werkOrderNummer + '\'' +
                ", aankoopOrderNummer='" + aankoopOrderNummer + '\'' +
                ", specificatie='" + specificatie + '\'' +
                ", totaal=" + totaal +
                ", klantNaam='" + klantNaam + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDTO orderDTO = (OrderDTO) o;

        if (orderId != orderDTO.orderId) return false;
        if (totaal != orderDTO.totaal) return false;
        if (werkOrderNummer != null ? !werkOrderNummer.equals(orderDTO.werkOrderNummer) : orderDTO.werkOrderNummer != null)
            return false;
        if (aankoopOrderNummer != null ? !aankoopOrderNummer.equals(orderDTO.aankoopOrderNummer) : orderDTO.aankoopOrderNummer != null)
            return false;
        if (specificatie != null ? !specificatie.equals(orderDTO.specificatie) : orderDTO.specificatie != null)
            return false;
        return klantNaam != null ? klantNaam.equals(orderDTO.klantNaam) : orderDTO.klantNaam == null;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (werkOrderNummer != null ? werkOrderNummer.hashCode() : 0);
        result = 31 * result + (aankoopOrderNummer != null ? aankoopOrderNummer.hashCode() : 0);
        result = 31 * result + (specificatie != null ? specificatie.hashCode() : 0);
        result = 31 * result + totaal;
        result = 31 * result + (klantNaam != null ? klantNaam.hashCode() : 0);
        return result;
    }
}
