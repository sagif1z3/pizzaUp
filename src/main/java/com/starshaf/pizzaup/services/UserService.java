package com.starshaf.pizzaup.services;

import com.starshaf.pizzaup.models.User;
import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> getAllUsers();

    User findUserById(Long id);

    User updateUser(User user);

    void deleteUser(Long id);
}
