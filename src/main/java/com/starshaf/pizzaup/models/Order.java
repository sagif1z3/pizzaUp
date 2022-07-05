package com.starshaf.pizzaup.models;

import com.starshaf.pizzaup.entities.PizzaEntity;
import com.starshaf.pizzaup.entities.UserEntity;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Order {
    private Long id;
    private UserEntity userEntity;
    private PizzaEntity pizzaEntity;
    private LocalDateTime dateTime;
}
