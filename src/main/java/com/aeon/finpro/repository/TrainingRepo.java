package com.aeon.finpro.repository;

import com.aeon.finpro.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepo extends JpaRepository<Training, Long> {
}
