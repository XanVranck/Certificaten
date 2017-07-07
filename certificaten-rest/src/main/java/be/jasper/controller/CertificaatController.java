package be.jasper.controller;

import be.jasper.domain.certificaat.Certificaat;
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
    private CertificaatService certificaatService;

    @Inject
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addCertificaat(@RequestParam (value = "certificaatNummer") String certificaatNummer,
                               @RequestParam (value = "certificaatDatum") String certificaatDatum,
                               @RequestParam (value = "specifiekTonnage") int specifiekTonnage,
                               @RequestParam (value = "orderID") int orderID){
        CertificaatDTO certificaat = new CertificaatDTO(orderID, certificaatNummer, certificaatDatum, specifiekTonnage);
        certificaatService.addCertificaat(certificaat);
    }

    @RequestMapping(path = "/{OrderId}", produces = "application/json",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<Certificaat> getCertificaten(@PathVariable(value = "OrderId") int orderId){
        Order order = orderService.findOrderById(orderId);
        return orderService.getCertificaten(order);
    }


}
