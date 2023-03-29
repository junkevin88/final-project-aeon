package com.aeon.finpro.service;

import com.aeon.finpro.dto.TrainingModel;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface TrainingService {

    public ResponseEntity<Map> insertTraining(TrainingModel trainingModel);
    public ResponseEntity<Map> updateTraining(TrainingModel trainingModel);
    public ResponseEntity<Map> getTrainingById(UUID id);
}
