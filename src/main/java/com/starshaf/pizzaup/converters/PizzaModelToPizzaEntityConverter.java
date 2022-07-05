package com.starshaf.pizzaup.converters;

import com.starshaf.pizzaup.entities.PizzaEntity;
import com.starshaf.pizzaup.models.PizzaModel;
import org.springframework.core.convert.converter.Converter;

public class PizzaModelToPizzaEntityConverter implements Converter<PizzaModel, PizzaEntity> {

    @Override
    public PizzaEntity convert(PizzaModel pizzaModel) {
        return  PizzaEntity.builder()
                .id(pizzaModel.getId())
                .name(pizzaModel.getName())
                .price(pizzaModel.getPrice())
                .size(pizzaModel.getSize())
                .toppings(pizzaModel.getToppings())
                .build();
    }
}
