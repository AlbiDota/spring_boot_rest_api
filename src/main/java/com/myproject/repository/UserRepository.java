package com.myproject.repository;

import com.myproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // query methods

    List<User> findAll(); //finner alle brukere

    List<User> getUserByEmail(String email); //finner på epost

    //@Query(value="SELECT * FROM User WHERE lastname LIKE %:lastname", nativeQuery=true)
    List <User> getUsersByLastname(String lastname); //finner på etternavn

    void deleteUser(String email);

}
