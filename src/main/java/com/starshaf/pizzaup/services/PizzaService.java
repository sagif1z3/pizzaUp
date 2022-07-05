package com.starshaf.pizzaup.services;

import com.starshaf.pizzaup.converters.PizzaEntityToPizzaModelConverter;
import com.starshaf.pizzaup.converters.PizzaModelToPizzaEntityConverter;
import com.starshaf.pizzaup.entities.PizzaEntity;
import com.starshaf.pizzaup.models.PizzaModel;
import com.starshaf.pizzaup.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaEntityToPizzaModelConverter pizzaEntityToPizzaModelConverter;
    private final PizzaModelToPizzaEntityConverter pizzaModelToPizzaEntityConverter;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository,
                        @Lazy PizzaEntityToPizzaModelConverter pizzaEntityToPizzaModelConverter,
                        @Lazy PizzaModelToPizzaEntityConverter pizzaModelToPizzaEntityConverter) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaEntityToPizzaModelConverter = pizzaEntityToPizzaModelConverter;
        this.pizzaModelToPizzaEntityConverter = pizzaModelToPizzaEntityConverter;
    }

    public PizzaModel getPizza(int id){
        return pizzaRepository.getPizzaModel(id);
    }

    public List<PizzaModel> getAllPizzas(){
        return pizzaRepository.getPizzasModels();
    }

    public void deletePizza(int id){
        pizzaRepository.deleteById(id);
    }

    public PizzaModel addPizza(PizzaModel pizzaModel){
        if(pizzaRepository.existsByName(pizzaModel.getName())){
            throw new RuntimeException("Pizza already exists");
        }
        return saveToDB(pizzaModel);
    }

    public PizzaModel updatePizza(PizzaModel pizzaModel){
        if(!pizzaRepository.existsById(pizzaModel.getId())){
            throw new RuntimeException("Pizza does not exists in db");
        }
        return saveToDB(pizzaModel);
    }

    private PizzaModel saveToDB(PizzaModel pizzaModel) {
        PizzaEntity pizzaEntity = pizzaModelToPizzaEntityConverter.convert(pizzaModel);
        if(pizzaEntity == null){
            throw new RuntimeException("Error creating a pizza object");
        }
        pizzaEntity = pizzaRepository.save(pizzaEntity);
        return pizzaEntityToPizzaModelConverter.convert(pizzaEntity);
    }
}
