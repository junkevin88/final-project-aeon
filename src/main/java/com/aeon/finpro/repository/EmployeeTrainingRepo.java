package com.aeon.finpro.repository;

import com.aeon.finpro.entity.EmployeeTraining;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface EmployeeTrainingRepo extends JpaRepository<EmployeeTraining, UUID> {
    @Query("select e from EmployeeTraining e where e.employee.name like %?1% and e.training.topic like %?2%")
    Page<EmployeeTraining> findListEmployeeTraining(String name, String topic, Pageable pageable);
}
