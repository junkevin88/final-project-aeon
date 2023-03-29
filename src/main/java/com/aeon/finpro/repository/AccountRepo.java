package com.aeon.finpro.repository;

import com.aeon.finpro.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.UUID;

public interface AccountRepo extends JpaRepository<Account, UUID> {
    @Query("select a from Account a where a.employee.id = ?1")
    Account findByEmployeeId(UUID id);

}
