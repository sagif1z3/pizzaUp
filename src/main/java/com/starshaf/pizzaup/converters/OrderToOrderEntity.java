package com.starshaf.pizzaup.converters;

import com.starshaf.pizzaup.entities.OrderEntity;
import com.starshaf.pizzaup.models.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderEntity implements Converter<Order, OrderEntity> {

    @Override
    public OrderEntity convert(Order source) {
            return OrderEntity.builder()
                    .id(source.getId())
                    .userEntity(source.getUserEntity())
                    .pizzaEntity(source.getPizzaEntity())
                    .dateTime(source.getDateTime())
                    .build();
    }
}
