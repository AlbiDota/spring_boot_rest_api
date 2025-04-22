package com.myproject.controller;

import com.myproject.model.User;
import com.myproject.repository.UserRepository;
import com.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User Controller", description = "API for users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET
    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping
    public User findUserByEmail(String email) {
        return userService.findUserByEmail(email);
    }

    @GetMapping
    public User getUserByLastName(String lastname) {
        return userService.getUserByLastname(lastname);
    }

    // SAVE
    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    // DELETE
    /*
    @PostMapping
    public void deleteUserByEmail(@PathVariable String email, @RequestBody User user) {
        userService.deleteUserByEmail(email);
    }
    */
}
