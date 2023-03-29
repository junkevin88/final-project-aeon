package com.aeon.finpro.repository;

import com.aeon.finpro.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrainingRepo extends JpaRepository<Training, UUID> {
}
