package com.starshaf.pizzaup.controller;

import com.starshaf.pizzaup.models.User;
import com.starshaf.pizzaup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addnew")
    public User addNewUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}/showbyid")
    public User findUserById (@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/showall")
    public List<User> showAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
