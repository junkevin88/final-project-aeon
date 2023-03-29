package com.aeon.finpro.repository;

import com.aeon.finpro.entity.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeDetailRepo extends JpaRepository<EmployeeDetail, UUID> {
}
