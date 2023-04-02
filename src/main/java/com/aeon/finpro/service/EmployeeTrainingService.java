package com.aeon.finpro.service;

import com.aeon.finpro.dto.EmployeeTrainingModel;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface EmployeeTrainingService {
    public ResponseEntity<Map> insertEmployeeTraining(EmployeeTrainingModel employeeTrainingModel);

}
