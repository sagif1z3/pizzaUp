package com.starshaf.pizzaup.converters;

import com.starshaf.pizzaup.entities.CartEntity;
import com.starshaf.pizzaup.models.CartModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CartEntityToCartModelConverter implements Converter<CartEntity, CartModel> {
    @Override
    public CartModel convert(CartEntity cartEntity) {
        return CartModel.builder()
                .id(cartEntity.getId())
                .pizzas(cartEntity.getPizzas())
                .totalPrice(cartEntity.getTotalPrice())
                .build();
    }
}
