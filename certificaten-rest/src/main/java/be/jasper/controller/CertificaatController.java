package be.jasper.controller;

import be.jasper.domain.certificaat.Certificaat;
import be.jasper.domain.certificaat.CertificaatFactory;
import be.jasper.domain.certificaat.CertificaatService;
import be.jasper.domain.order.Order;
import be.jasper.domain.order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/certificaat")
@Transactional
public class CertificaatController {
    @Inject
    private OrderService orderService;

    @Inject
    private CertificaatService certificaatService;

    @Inject
    private CertificaatFactory certificaatFactory;

    private int orderIdField;

    @RequestMapping(path = "/{orderId}", produces = "application/json", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<CertificaatDTO> getCertificaten(@PathVariable(value = "orderId") int orderId) {
        orderIdField = orderId;
        Order order = orderService.findOrderById(orderIdField);
        return orderService.getCertificaten(order);
    }

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addCertificaat(@RequestBody CertificaatDTO certificaatDTO) {
        Order order = orderService.findOrderById(orderIdField);
        Certificaat certificaat = certificaatFactory.createCertificaat(certificaatDTO);
        orderService.addCertificaat(order, certificaat);
//        int orderId = order.getOrderID();
//        int certificaatId = certificaat.getCertificaatID();
//        orderService.mapOrderWithCertificaat(orderId, certificaatId);
//        certificaatService.addCertificaat(order, certificaat);
    }
}
