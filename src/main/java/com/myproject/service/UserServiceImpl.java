package com.myproject.service;

import com.myproject.model.User;
import com.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // ------ GET -------
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userid) {
        return userRepository.findById(userid).orElse(null);
    }

    @Override
    public List<User> getUsersByNameLike(String username) {
        return userRepository.findByUsernameContainingIgnoreCase(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //------- PUT -------
    @Override
    public User updateUser(Long userid, User updatedUser) {
        return userRepository.findById(userid).map(
                        user -> {
                            user.setUsername(updatedUser.getUsername());
                            user.setEmail(updatedUser.getEmail());
                            user.setBirthday(updatedUser.getBirthday());
                            return userRepository.save(user);
                        })
                .orElseThrow(() -> new RuntimeException("User not found" + userid));
    }


    //------- POST -------
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //------- DELETE -------
    @Override
    public void deleteUserByUserId(Long userid) { userRepository.deleteById(userid);}

    @Override
    public void deleteUserByEmail(String email) { userRepository.deleteUserByEmail(email);}
}
