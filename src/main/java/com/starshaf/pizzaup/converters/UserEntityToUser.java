package com.starshaf.pizzaup.converters;

import com.starshaf.pizzaup.entities.UserEntity;
import com.starshaf.pizzaup.models.User;
import com.sun.istack.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUser implements Converter<UserEntity, User> {


    @Override
    public User convert(@NotNull UserEntity source) {
        User user = new User();
        user.setId(source.getId());
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setCity(source.getCity());
        user.setAddress(source.getAddress());
        user.setPhoneNumber(source.getPhoneNumber());
        return user;
    }
}
