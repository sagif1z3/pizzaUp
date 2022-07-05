package com.starshaf.pizzaup.converters;

import com.starshaf.pizzaup.entities.CartEntity;
import com.starshaf.pizzaup.models.CartModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class CartModelToCartEntityConverter implements Converter<CartModel, CartEntity> {
    @Override
    public CartEntity convert(CartModel cartModel) {
        return CartEntity.builder()
                .id(cartModel.getId())
                .pizzas(cartModel.getPizzas())
                .totalPrice(cartModel.getTotalPrice())
                .build();
    }
}
