package be.jasper.controller;

import be.jasper.domain.order.Order;
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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void addOrder(@RequestParam (value = "werkOrderNummer") String werkOrderNummer,
                         @RequestParam (value = "aankoopOrderNummer") String aankoopOrderNummer,
                         @RequestParam (value = "specificatie") String specificatie,
                         @RequestParam (value = "totaal") int totaal,
                         @RequestParam (value = "klantId") int klantId){
        OrderDTO order = new OrderDTO(werkOrderNummer, aankoopOrderNummer, specificatie, totaal, klantId);
        orderService.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getOrders(){
        return orderService.getOrders();
    }
}
