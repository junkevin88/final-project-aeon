package com.aeon.finpro.repository;

import com.aeon.finpro.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface EmployeeRepo extends JpaRepository<Employee, UUID> {
    @Query("select e from Employee e where e.name like %?1%")
    Page<Employee> findListEmployee(String name, Pageable pageable);


}
