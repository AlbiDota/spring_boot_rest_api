package com.myproject.repository;

import com.myproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // query methods

    List<User> findAll(); //finner alle brukere

    List<User> findUserByEmail(String email); //finner på epost

    List<User> findUsersByLastname(String lastname);

    void deleteUserByEmail(String email);

    List<User> findByLastname(String lastname);
}
