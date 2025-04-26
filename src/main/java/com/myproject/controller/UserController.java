package com.myproject.controller;

import com.myproject.model.User;
import com.myproject.repository.UserRepository;
import com.myproject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@Tag(name = "User Controller")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    UserRepository userRepository;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ------ GET -------
    @GetMapping("/get-id/{userid}")
    @Operation(summary="Get user by ID", description = "Get user by ID")
    public User getUserById(@PathVariable Long userid) {
        return userService.getUserById(userid);
    }

    @GetMapping("/get-email/{email}")
    @Operation(summary="Get user by email", description = "Get user by email")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/get-name/{username}")
    @Operation(summary="Get all users with matching name", description = "List all users by searching for a name")
    public List<User> getUsersByNameLike(@PathVariable String username) {
        return userService.getUsersByNameLike(username);
    }

    @GetMapping("/get/")
    @Operation(summary="Get all users", description = "List all users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //----- PUT ----
    // @PutMapping("/{id}")
    // @Operation(summary="Update user", description = "Update user details")
    //public void updateUser(@RequestBody User user) {userService.updateUser(user);}

    @PutMapping("/{userid}")
    @Operation(summary="Update user", description = "Update user details")
    public ResponseEntity<User> updateUser(@PathVariable Long userid, @RequestBody User updatedUser) {
        try {
            User user = userService.updateUser(userid, updatedUser);
            return new ResponseEntity<>(user, HttpStatus.OK); //return update and code 200 - OK
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //returning 404 not found if .. yknow
        }
    }

    //----- POST ----
//    @PostMapping
//    @Operation(summary="Create user", description = "Create a new user")
//    public void saveUser(@RequestBody User user) {
//        userService.saveUser(user);
//    }

    @PostMapping
    @Operation(summary="Create user", description = "Create a new user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setUserid(null); //for å ikke måtte skrive inn ID i swagger!!
        User savedUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    //----- DELETE ----
    @DeleteMapping("/delete-id/{userid}")
    @Operation(summary="Delete user by ID", description = "Delete a user using ID")
    public void deleteUserByUserId(@PathVariable Long userid) { userService.deleteUserByUserId(userid);}

    @DeleteMapping("/delete-email/{email:.+}") //for spesialtegn
    @Operation(summary="Delete user by email", description = "Delete a user using email")
    public void deleteUserByEmail(@PathVariable String email) { userService.deleteUserByEmail(email);}
}