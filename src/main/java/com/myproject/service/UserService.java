package com.myproject.service;
import com.myproject.model.User;

import java.util.List;

public interface UserService {

    // fetch all users
    List<User> getAllUsers();

    // fetch a user by id
    User getUserById(Long userid);

    // fetch a user by name
    List<User> getUsersByNameLike(String username);

    // fetch a user by email
    User getUserByEmail(String email);

    // update a user
    User updateUser(Long userid, User updatedUser);

    // create a user
    //void createUser(User user);
    User createUser(User user);
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }


    // delete a user by id
    void deleteUserByUserId(Long userid);

    // delete a user by email
    void deleteUserByEmail(String email);
}