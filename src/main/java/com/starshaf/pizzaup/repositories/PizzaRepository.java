package com.starshaf.pizzaup.repositories;

import com.starshaf.pizzaup.entities.PizzaEntity;
import com.starshaf.pizzaup.models.PizzaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {
    boolean existsByName(String name);

    @Query("SELECT new com.starshaf.pizzaup.models.PizzaModel(p.id, p.name, p.size, p.toppings, p.price) " +
            "FROM PizzaEntity p WHERE p.id= :id")
    PizzaModel getPizzaModel(@Param("id") int id);

    @Query("SELECT new com.starshaf.pizzaup.models.PizzaModel(p.id, p.name, p.size, p.toppings, p.price) " +
            "FROM PizzaEntity p")
    List<PizzaModel> getPizzasModels();
}
