package com.starshaf.pizzaup.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carts")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    @JoinTable(name = "cart_item"
            , joinColumns = @JoinColumn(name = "cart_id")
            , inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    private List<PizzaEntity> pizzas;

    @Column(name = "total_price")
    private float totalPrice;
}
