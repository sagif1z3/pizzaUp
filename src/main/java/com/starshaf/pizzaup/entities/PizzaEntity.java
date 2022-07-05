package com.starshaf.pizzaup.entities;

import com.starshaf.pizzaup.enums.Size;
import com.starshaf.pizzaup.enums.Toppings;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "pizzas")
public class PizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private Size size;

    @Enumerated(EnumType.STRING)
    @Column(name = "toppings")
    private Toppings toppings;

    @Column(name = "price")
    private float price;
}
