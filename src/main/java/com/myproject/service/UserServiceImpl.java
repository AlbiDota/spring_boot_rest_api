package com.myproject.service;

import com.myproject.model.User;
import com.myproject.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    // ---------- GET
    //Get all users
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //Get user by email
    @Override
    public User findUserByEmail(String email) {
        return (User) userRepository.findUserByEmail(email);
    }

    @Override
    public User getUserByLastname(String lastname) {
        return (User) userRepository.findByLastname(lastname);
    }

    //Get user by lastname
    public User getUserByLastname(String lastname) {
        return (User) userRepository.findUsersByLastname(lastname);
    }

    // ---------- SAVE
    //Create a user
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // ---------- DELETE
    //DELETE a user
    @Override
    public void deleteUser(String email) {
        userRepository.deleteUserByEmail(email);
    }

    // ---------- PUT
    //UPDATE a user
    @Override
    public User updateUser(String email, String password, String firstname, String lastname) {
        return null; //idk
    }
}
