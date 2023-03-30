package com.aeon.finpro.repository;

import com.aeon.finpro.entity.User;
import com.aeon.finpro.entity.enumeration.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);

    Optional<User> findByToken(String token);
}
