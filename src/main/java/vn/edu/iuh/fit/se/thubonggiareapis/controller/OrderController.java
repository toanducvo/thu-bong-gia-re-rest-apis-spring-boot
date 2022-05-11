package vn.edu.iuh.fit.se.thubonggiareapis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.se.thubonggiareapis.dto.OrderDTO;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IOrderService;
import vn.edu.iuh.fit.se.thubonggiareapis.service.IPromotionService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IPromotionService promotionService;

    @GetMapping(value = "/{id}", name = "Get order by id")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping(value = {"", "/"}, consumes = {
            "application/json",
            "application/x-www-form-urlencoded"
    }, name = "Add an order")
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }
}
