package be.jasper.domain.order;

/**
 * Created by xanv on 11/05/2017.
 */
public class OrderTestBuilder {
    private String werkOrderNummer;
    private String aankoopOrderNummer;
    private String specificatie;
    private int totaal;

    public OrderTestBuilder(){
        werkOrderNummer = "105";
        aankoopOrderNummer = "520";
        specificatie = "Specs";
        totaal=900;
    }

    private static OrderTestBuilder builder(){
        return new OrderTestBuilder();
    }

    public OrderTestBuilder withWerkOrderNummer(String werkOrderNummer) {
        this.werkOrderNummer = werkOrderNummer;
        return this;
    }

    public OrderTestBuilder withAankoopOrderNummer(String aankoopOrderNummer) {
        this.aankoopOrderNummer = aankoopOrderNummer;
        return this;
    }

    public OrderTestBuilder withSpecificatie(String specificatie) {
        this.specificatie = specificatie;
        return this;
    }

    public OrderTestBuilder withTotaal(int totaal) {
        this.totaal = totaal;
        return this;
    }

    public Order build(){
        return new Order(werkOrderNummer, aankoopOrderNummer, specificatie, totaal);
    }
}
