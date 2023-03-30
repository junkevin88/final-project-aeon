package com.aeon.finpro.repository;

import com.aeon.finpro.entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.UUID;

public interface EmployeeDetailRepo extends JpaRepository<EmployeeDetail, UUID> {
    @Query(value = "select e from EmployeeDetail e where e.employee.id = ?1")
    EmployeeDetail findByEmployeeId(UUID employeeId);

}
