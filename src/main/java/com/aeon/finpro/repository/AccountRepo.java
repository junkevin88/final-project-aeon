package com.aeon.finpro.repository;

import com.aeon.finpro.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepo extends JpaRepository<Account, UUID> {

}
