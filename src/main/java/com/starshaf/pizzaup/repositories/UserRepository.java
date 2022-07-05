package com.starshaf.pizzaup.repositories;

import com.starshaf.pizzaup.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
