package com.starshaf.pizzaup.services;

import com.starshaf.pizzaup.converters.OrderEntityToOrder;
import com.starshaf.pizzaup.converters.OrderToOrderEntity;
import com.starshaf.pizzaup.models.Order;
import com.starshaf.pizzaup.repositories.OrderRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderEntityToOrder orderEntityToOrder;
    private OrderToOrderEntity orderToOrderEntity;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            @Lazy OrderEntityToOrder orderEntityToOrder,
                            @Lazy OrderToOrderEntity orderToOrderEntity) {
        this.orderRepository = orderRepository;
        this.orderEntityToOrder = orderEntityToOrder;
        this.orderToOrderEntity = orderToOrderEntity;
    }

    @Override
    public Order addOrder(Order order) {
        return Optional.ofNullable(orderToOrderEntity.convert(order))
                .map(orderRepository::save)
                .map(orderEntityToOrder::convert)
                .orElseThrow(() -> new RuntimeException("Cannot add order"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderEntityToOrder::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderEntityToOrder::convert)
                .orElseThrow(()->new RuntimeException("Cannot find order by id, order is not exist"));
    }

    @Override
    public Order updateOrder(Order order) {
        return Optional.ofNullable(orderToOrderEntity.convert(order))
                .map(orderRepository::save)
                .map(orderEntityToOrder::convert)
                .orElseThrow(()-> new RuntimeException("Cannot update order"));
    }

    @Override
    public void deleteOrder(Long id) {
        Optional.ofNullable(orderToOrderEntity.convert(findOrderById(id)))
                .ifPresent(orderRepository::delete);
    }
}
