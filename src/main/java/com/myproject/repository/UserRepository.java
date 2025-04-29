package com.myproject.repository;
import com.myproject.model.User;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findAll();

    //User findById(Long id);

    //@Query("SELECT u FROM User u WHERE u.name LIKE :name")
    //List<User> findUsersByNameLike(@Param("name") String name);

    List<User> findByUsernameContainingIgnoreCase(String username);
    User findByEmail(String email);

    void deleteUserByUserid(String userid);

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.email = ?1")
    void deleteUserByEmail(String email);


}