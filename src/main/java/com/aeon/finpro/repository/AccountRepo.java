package com.aeon.finpro.repository;

import com.aeon.finpro.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {

}
