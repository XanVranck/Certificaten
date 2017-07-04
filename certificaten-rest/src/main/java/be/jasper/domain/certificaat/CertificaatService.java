package be.jasper.domain.certificaat;

import be.jasper.controller.CertificaatDTO;
import be.jasper.domain.order.Order;
import be.jasper.domain.order.OrderRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CertificaatService {
    @Inject
    private CertificaatRepository certificaatRepository;

    @Inject
    private EntityManager entityManager;

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private CertificaatFactory certificaatFactory;

    public List<Certificaat> getCertificaten() {
        return certificaatRepository.getCertificaten();
    }

    public void addCertificaat(CertificaatDTO certificaat){
        Order order= orderRepository.findOrder(certificaat.getOrderId());

        order.addCertificaat(certificaatFactory.createCertificaat(certificaat));
    }
}
