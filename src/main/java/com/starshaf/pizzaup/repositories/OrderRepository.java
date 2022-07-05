package com.starshaf.pizzaup.repositories;

import com.starshaf.pizzaup.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
