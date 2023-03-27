package com.aeon.finpro.repository;

import com.aeon.finpro.entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailRepo extends JpaRepository<EmployeeDetail, Long> {
}
