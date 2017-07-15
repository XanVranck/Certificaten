package be.jasper.controller;

import be.jasper.domain.certificaat.Certificaat;
import be.jasper.domain.klant.Klant;
import be.jasper.domain.klant.KlantRepository;
import be.jasper.domain.order.Order;
import be.jasper.domain.order.OrderRepository;
import be.jasper.infrastructure.SpringIntegrationTest;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by xanv on 15/07/2017.
 */
public class CertificaatControllerTest extends SpringIntegrationTest {
    private KlantDTO nenaDTO;
    private OrderDTO orderDTO;
    private CertificaatDTO certificaatDTO;
    private Order order;
    private Klant klant;
    private Certificaat certificaat;
    private List<CertificaatDTO> certificaatDTOList = new ArrayList<>();
    @Inject
    private KlantController klantController;

    @Inject
    private KlantRepository klantRepository;

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private OrderController orderController;

    @Inject
    private CertificaatController certificaatController;

    @Before
    public void setUp() throws Exception {
        nenaDTO = new KlantDTO(1,"Nena");
        orderDTO = new OrderDTO(1,"werkOrderNummer", "aankoopOrderNummer", "Specificatie", 200, "Nena");
        certificaatDTO = new CertificaatDTO(0,1,"certificaatNummer", new Date(), 150);
        order = new Order("werkOrderNummer", "aankoopOrderNummer", "Specificatie", 200);
        klant = new Klant("Xan");
        certificaat = new Certificaat("certificaatNummer", new Date(), 150);
        klantRepository.addKlant(klant);
        orderRepository.addOrder(order);
        certificaatDTOList.add(certificaatDTO);
        certificaatController.getCertificaten(1);
    }

    @Test
    public void addCertificaatToOrder_returnsCertificaat() throws Exception {
        klantController.addKlant(nenaDTO);
        orderController.addOrder(orderDTO);
        certificaatController.addCertificaat(certificaatDTO);

        assertThat(certificaatController.getCertificaten(1)).isEqualTo(certificaatDTOList);
    }
}