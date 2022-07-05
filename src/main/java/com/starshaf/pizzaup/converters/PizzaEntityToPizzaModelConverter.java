package com.starshaf.pizzaup.converters;

import com.starshaf.pizzaup.entities.PizzaEntity;
import com.starshaf.pizzaup.models.PizzaModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class PizzaEntityToPizzaModelConverter implements Converter<PizzaEntity, PizzaModel> {
    @Override
    public PizzaModel convert(PizzaEntity pizzaEntity) {
        return PizzaModel.builder()
                .id(pizzaEntity.getId())
                .name(pizzaEntity.getName())
                .price(pizzaEntity.getPrice())
                .size(pizzaEntity.getSize())
                .toppings(pizzaEntity.getToppings())
                .build();
    }
}
