package com.starshaf.pizzaup.controllers;

import com.starshaf.pizzaup.models.Order;
import com.starshaf.pizzaup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/addnew")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping("/{id}/showbyid")
    public Order showCompanyById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    @GetMapping("/showall")
    public List<Order> showAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteOrder(Long id){
        orderService.deleteOrder(id);
    }


}
