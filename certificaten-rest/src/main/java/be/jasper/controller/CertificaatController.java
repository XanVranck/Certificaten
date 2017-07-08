package be.jasper.controller;

import be.jasper.domain.certificaat.Certificaat;
import be.jasper.domain.certificaat.CertificaatFactory;
import be.jasper.domain.certificaat.CertificaatService;
import be.jasper.domain.order.Order;
import be.jasper.domain.order.OrderFactory;
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

    @Inject
    private OrderFactory orderFactory;

    @Inject
    private CertificaatFactory certificaatFactory;

    private Order order = new Order();

    @RequestMapping(path = "/{orderId}", produces = "application/json", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<Certificaat> getCertificaten(@PathVariable(value = "orderId") int orderId) {
        order = orderService.findOrderById(orderId);
        return orderService.getCertificaten(order);
    }

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addCertificaat(@RequestBody Certificaat certificaat) {
        orderService.addCertificaat(order, certificaat);
    }
}
