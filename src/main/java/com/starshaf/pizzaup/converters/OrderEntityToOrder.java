package com.starshaf.pizzaup.converters;

import com.starshaf.pizzaup.entities.OrderEntity;
import com.starshaf.pizzaup.models.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityToOrder implements Converter<OrderEntity, Order> {

    @Override
    public Order convert(OrderEntity source) {
         Order order = new Order();
         order.setId(source.getId());
         order.setUserEntity(source.getUserEntity());
         order.setPizzaEntity(source.getPizzaEntity());
         order.setDateTime(source.getDateTime());
         return order;
    }
}
