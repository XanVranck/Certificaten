package be.jasper.controller;

import be.jasper.domain.klant.Klant;
import be.jasper.domain.klant.KlantService;
import be.jasper.domain.order.Order;
import be.jasper.domain.order.OrderFactory;
import be.jasper.domain.order.OrderService;
import be.jasper.errorhandler.KlantNietGevonden;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/order")
@Transactional
public class OrderController {
    @Inject
    private OrderFactory orderFactory;

    @Inject
    private OrderService orderService;

    @Inject
    private KlantService klantService;

    @RequestMapping(method = POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addOrder(@RequestBody OrderDTO orderDTO) throws KlantNietGevonden {
        String klantNaam = orderDTO.getKlantNaam();
        Klant klant = klantService.findKlantByNaam(klantNaam);
        Order order = orderFactory.createOrder(orderDTO);
        klantService.addOrder(klant, order);
    }

    @RequestMapping(path = "/{klantNaam}", produces = "application/json", method = GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<OrderDTO> getOrders(@PathVariable(value = "klantNaam") String klantNaam)  {
        Klant klant = klantService.findKlantByNaam(klantNaam);

        return klantService.getOrders(klant);
    }

    @RequestMapping(method = PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void updateOrder(@RequestBody OrderDTO orderDTO) {
        orderService.updateOrder(orderDTO);
    }

}