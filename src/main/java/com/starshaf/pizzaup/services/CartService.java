package com.starshaf.pizzaup.services;

import com.starshaf.pizzaup.converters.CartEntityToCartModelConverter;
import com.starshaf.pizzaup.converters.CartModelToCartEntityConverter;
import com.starshaf.pizzaup.converters.PizzaModelToPizzaEntityConverter;
import com.starshaf.pizzaup.entities.CartEntity;
import com.starshaf.pizzaup.models.CartModel;
import com.starshaf.pizzaup.repositories.CartRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final PizzaService pizzaService;
    private final PizzaModelToPizzaEntityConverter pizzaModelToPizzaEntityConverter;
    private final CartEntityToCartModelConverter cartEntityToCartModelConverter;
    private final CartModelToCartEntityConverter cartModelToCartEntityConverter;

    public CartService(CartRepository cartRepository, @Lazy PizzaService pizzaService, @Lazy PizzaModelToPizzaEntityConverter pizzaModelToPizzaEntityConverter, @Lazy CartEntityToCartModelConverter cartEntityToCartModelConverter, @Lazy CartModelToCartEntityConverter cartModelToCartEntityConverter) {
        this.cartRepository = cartRepository;
        this.pizzaService = pizzaService;
        this.pizzaModelToPizzaEntityConverter = pizzaModelToPizzaEntityConverter;
        this.cartEntityToCartModelConverter = cartEntityToCartModelConverter;
        this.cartModelToCartEntityConverter = cartModelToCartEntityConverter;
    }

    public CartModel addCart(CartModel cartModel){
        CartEntity cartEntity = cartModelToCartEntityConverter.convert(cartModel);
        if(cartEntity == null){
            throw new RuntimeException("Error Trying to add cart");
        }
        cartEntity = cartRepository.save(cartEntity);
        return cartEntityToCartModelConverter.convert(cartEntity);
    }

    public CartModel updateCart(CartModel cartModel){
        if(!cartRepository.existsById(cartModel.getId())){
            throw new RuntimeException("Cart does not exists");
        }
        return addCart(cartModel);
    }

    public void deleteCart(long id){
        cartRepository.deleteById(id);
    }

    public void addPizzaToCart(int pizzaId, long cartId){
        Optional<CartEntity> optionalCartEntity = cartRepository.findById(cartId);
        if(optionalCartEntity.isEmpty()){
            throw new RuntimeException("Cart does not exists");
        }
        CartEntity cartEntity = optionalCartEntity.get();
        cartEntity.getPizzas().add(pizzaModelToPizzaEntityConverter.convert(pizzaService.getPizza(pizzaId)));
        updateCart(Objects.requireNonNull(cartEntityToCartModelConverter.convert(cartEntity)));
    }

    public void removePizzaFromCart(int pizzaId, long cartId){
        Optional<CartEntity> optionalCartEntity = cartRepository.findById(cartId);
        if(optionalCartEntity.isEmpty()){
            throw new RuntimeException("Cart does not exists");
        }
        CartEntity cartEntity = optionalCartEntity.get();
        cartEntity.setPizzas(cartEntity.getPizzas()
                            .stream()
                            .filter(pizzaEntity -> pizzaEntity.getId() != pizzaId)
                            .collect(Collectors.toList()));
        CartModel cartModel = cartEntityToCartModelConverter.convert(cartEntity);
        if(cartModel == null){
            throw new RuntimeException("Error trying remove item from the cart");
        }
        updateCart(cartModel);
    }

    public List<CartModel> getAllCarts(){
        return cartRepository.findAll().stream().map(cartEntityToCartModelConverter::convert).collect(Collectors.toList());
    }

    public CartModel getCart(long id){
        return cartEntityToCartModelConverter.convert(cartRepository.findById(id).get());
    }
}
