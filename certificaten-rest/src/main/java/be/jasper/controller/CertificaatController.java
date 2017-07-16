package be.jasper.controller;

import be.jasper.domain.certificaat.Certificaat;
import be.jasper.domain.certificaat.CertificaatFactory;
import be.jasper.domain.certificaat.CertificaatService;
import be.jasper.domain.order.Order;
import be.jasper.domain.order.OrderService;
import be.jasper.errorhandler.CertificaatNietGevonden;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/certificaat")
@Transactional
public class CertificaatController {
    @Inject
    private OrderService orderService;

    @Inject
    private CertificaatFactory certificaatFactory;

    @Inject
    private CertificaatService certificaatService;

    private int orderIdField;

    @RequestMapping(path = "/{orderId}", produces = "application/json", method = GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<CertificaatDTO> getCertificaten(@PathVariable(value = "orderId") int orderId) {
        orderIdField = orderId;
        Order order = orderService.findOrderById(orderIdField);
        return orderService.getCertificaten(order);
    }

    @RequestMapping(method = POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addCertificaat(@RequestBody CertificaatDTO certificaatDTO) {
        Order order = orderService.findOrderById(orderIdField);
        Certificaat certificaat = certificaatFactory.createCertificaat(certificaatDTO);
        orderService.addCertificaat(order, certificaat);
    }

    @RequestMapping(method = PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void updateCertificaat(@RequestBody CertificaatIdDTO certificaatIdDTO) throws CertificaatNietGevonden {
        certificaatService.updateCertificaat(certificaatIdDTO);
    }

    @RequestMapping(method = DELETE)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void deleteCertificaat(@RequestParam (value = "certificaatId") int certificaatId){
        certificaatService.deleteCertificaat(certificaatId);
    }

}
