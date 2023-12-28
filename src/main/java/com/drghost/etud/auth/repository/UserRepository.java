package com.drghost.etud.auth.repository;

import com.drghost.etud.auth.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
    // Since email is unique, we will find users by email
    Optional<User> findByEmail(String Email);
}
