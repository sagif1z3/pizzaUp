package com.starshaf.pizzaup.service;

import com.starshaf.pizzaup.converters.UserEntityToUser;
import com.starshaf.pizzaup.converters.UserToUserEntity;
import com.starshaf.pizzaup.models.User;
import com.starshaf.pizzaup.repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserToUserEntity userToUserEntity;
    private UserEntityToUser userEntityToUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           @Lazy UserToUserEntity userToUserEntity,
                           @Lazy UserEntityToUser userEntityToUser) {
        this.userRepository = userRepository;
        this.userToUserEntity = userToUserEntity;
        this.userEntityToUser = userEntityToUser;
    }

    @Override
    public User addUser(User user) {
        return Optional.ofNullable(userToUserEntity.convert(user))
                .map(userRepository::save)
                .map(userEntityToUser::convert)
                .orElseThrow(() -> new RuntimeException("Cannot add user"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userEntityToUser::convert)
                .collect(Collectors.toList());
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .map(userEntityToUser::convert)
                .orElseThrow(()-> new RuntimeException("Cannot find user by id, user does not exist"));
    }

    @Override
    public User updateUser(User user) {
        return Optional.ofNullable(userToUserEntity.convert(user))
                .map(userRepository::save)
                .map(userEntityToUser::convert)
                .orElseThrow(()-> new RuntimeException("Cannot update user"));
    }

    @Override
    public void deleteUser(Long id) {
        Optional.ofNullable(userToUserEntity.convert(findUserById(id)))
                .ifPresent(userRepository::delete);
    }
}
