package com.aeon.finpro.repository;

import com.aeon.finpro.entity.EmployeeTraining;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeTrainingRepo extends JpaRepository<EmployeeTraining, UUID> {
}
