package be.jasper.controller;

import be.jasper.domain.klant.Klant;
import be.jasper.domain.klant.KlantService;
import be.jasper.domain.order.Order;
import be.jasper.domain.order.OrderFactory;
import be.jasper.domain.order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/order")
@Transactional
public class OrderController {
    @Inject
    private OrderService orderService;

    @Inject
    private OrderFactory orderFactory;

    @Inject
    private KlantService klantService;

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addOrder(@RequestBody OrderDTO orderDTO) {
        String klantNaam = orderDTO.getKlantNaam();
        Klant klant = klantService.findKlantByNaam(klantNaam);
        Order order = orderFactory.createOrder(orderDTO);
        klantService.addOrder(klant, order);
    }

    @RequestMapping(path = "/{klantNaam}", produces = "application/json", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<Order> getOrders(@PathVariable(value = "klantNaam") String klantNaam) {
        Klant klant = klantService.findKlantByNaam(klantNaam);
        return klantService.getOrders(klant);
    }
}