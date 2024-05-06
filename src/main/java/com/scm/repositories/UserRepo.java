package com.scm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    //extra DB related operations
    //custom query methods
    //custom finder methods

    Optional<User> findByEmail(String email); //no need to write query //spring data JPA will provide its implementation

    
}
