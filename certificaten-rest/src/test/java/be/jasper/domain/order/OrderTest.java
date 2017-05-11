package be.jasper.domain.order;

import be.jasper.domain.certificaat.Certificaat;
import be.jasper.domain.certificaat.CertificaatTestBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xanv on 11/05/2017.
 */
public class OrderTest {
    private Order order;

    @Before
    public void setUp() throws Exception {
        order = new OrderTestBuilder().build();

    }

    @Test
    public void getWerkOrderNummer() throws Exception {
        assertThat(order.getWerkOrderNummer()).isEqualTo("105");
    }

    @Test
    public void getAankoopOrderNummer() throws Exception {
        assertThat(order.getAankoopOrderNummer()).isEqualTo("520");
    }

    @Test
    public void getSpecificatie() throws Exception {
        assertThat(order.getSpecificatie()).isEqualTo("Specs");
    }

    @Test
    public void getTotaal() throws Exception {
        assertThat(order.getTotaal()).isEqualTo(900);
    }

    @Test
    public void addCertificaat_ShouldAddACertificateToAnOrder() throws Exception {
        Certificaat certificaat = new CertificaatTestBuilder().build();
        order.addCertificaat(certificaat);

        assertThat(order.getCertificaten()).contains(certificaat);

    }
}