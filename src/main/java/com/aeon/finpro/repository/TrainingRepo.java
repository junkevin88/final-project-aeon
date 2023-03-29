package com.aeon.finpro.repository;

import com.aeon.finpro.entity.Employee;
import com.aeon.finpro.entity.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TrainingRepo extends JpaRepository<Training, UUID> {

    @Query("select e from Training e where e.topic like %?1%")
    Page<Employee> findListTraining(String topic, Pageable pageable);
}
