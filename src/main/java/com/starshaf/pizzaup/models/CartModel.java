package com.starshaf.pizzaup.models;

import com.starshaf.pizzaup.entities.PizzaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartModel {
    private long id;
    private List<PizzaEntity> pizzas;
    private float totalPrice;
}
