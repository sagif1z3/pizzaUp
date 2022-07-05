package com.starshaf.pizzaup.converters;

import com.starshaf.pizzaup.entities.UserEntity;
import com.starshaf.pizzaup.models.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserEntity implements Converter<User, UserEntity> {

    @Override
    public UserEntity convert(User source) {
        return UserEntity.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .city(source.getCity())
                .address(source.getAddress())
                .phoneNumber(source.getPhoneNumber())
                .build();
    }
}
