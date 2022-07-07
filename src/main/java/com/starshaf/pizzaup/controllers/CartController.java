package com.starshaf.pizzaup.controllers;

import com.starshaf.pizzaup.models.CartModel;
import com.starshaf.pizzaup.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public CartModel addCart(@RequestBody CartModel cartModel){
        return cartService.addCart(cartModel);
    }

    @PutMapping("/add/cart/{cartId}/pizza/{pizzaId}")
    public void removePizzaFromCart(@PathVariable("cartId") long cartId, @PathVariable("pizzaId") int pizzaId){
        cartService.removePizzaFromCart(pizzaId, cartId);
    }

    @PutMapping("/remove/{cartId}/{pizzaId}")
    public void addPizzaToCart(@PathVariable("cartId") long cartId, @PathVariable("pizzaId") int pizzaId){
        cartService.addPizzaToCart(pizzaId, cartId);
    }

    @PutMapping
    public CartModel updateCart(@RequestBody CartModel cartModel){
        return cartService.updateCart(cartModel);
    }

    @GetMapping
    public List<CartModel> getAllCarts(){
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public CartModel getCart(@PathVariable("id") long id){
        return cartService.getCart(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable("id") long id){
        cartService.deleteCart(id);
    }
}
