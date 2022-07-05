package com.starshaf.pizzaup.models;

import com.starshaf.pizzaup.enums.Size;
import com.starshaf.pizzaup.enums.Toppings;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class PizzaModel {
    private int id;
    private String name;
    private Size size;
    private Toppings toppings;
    private float price;
}
