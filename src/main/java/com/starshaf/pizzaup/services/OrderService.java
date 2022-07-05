package com.starshaf.pizzaup.services;

import com.starshaf.pizzaup.models.Order;
import java.util.List;

public interface OrderService {

    Order addOrder(Order order);

    List<Order> getAllOrders();

    Order findOrderById(Long id);

    Order updateOrder(Order order);

    void deleteOrder(Long id);
}
