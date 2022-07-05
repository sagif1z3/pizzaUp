package com.starshaf.pizzaup.controllers;

import com.starshaf.pizzaup.models.PizzaModel;
import com.starshaf.pizzaup.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public PizzaModel addPizza(@RequestBody PizzaModel pizzaModel){
        return pizzaService.addPizza(pizzaModel);
    }

    @PutMapping
    public PizzaModel updatePizza(@RequestBody PizzaModel pizzaModel){
        return pizzaService.updatePizza(pizzaModel);
    }

    @GetMapping
    public List<PizzaModel> getAllPizzas(){
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public PizzaModel getPizzaModel(@PathVariable("id") int id){
        return pizzaService.getPizza(id);
    }

    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable("id") int id){
        pizzaService.deletePizza(id);
    }
}
