package com.starshaf.pizzaup.repositories;

import com.starshaf.pizzaup.entities.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
