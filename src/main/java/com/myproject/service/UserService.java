package com.myproject.service;
import com.myproject.model.User;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public interface UserService {

    // ---------- GET
    //Get all users
    List<User> getUsers();

    //Get user by email
    User getUserByEmail(String email);

    //Get user by lastname
    User getUserByLastname(String lastname);

    // ---------- SAVE
    //Create a user
    User createUser(User user);

    // ---------- DELETE
    //DELETE a user
    void deleteUser(String email);

    // ---------- PUT
    //UPDATE a user
    User updateUser(String email, String password, String firstname, String lastname);


}
