package com.aeon.finpro.service.impl;

import com.aeon.finpro.dto.EmployeeTrainingModel;
import com.aeon.finpro.entity.Employee;
import com.aeon.finpro.entity.EmployeeTraining;
import com.aeon.finpro.entity.Training;
import com.aeon.finpro.repository.EmployeeRepo;
import com.aeon.finpro.repository.TrainingRepo;
import com.aeon.finpro.service.EmployeeTrainingService;
import com.aeon.finpro.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class EmployeeTrainingServiceImpl implements EmployeeTrainingService {
    @Autowired
    private Response response;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private TrainingRepo trainingRepo;


    @Override
    public ResponseEntity<Map> insertTraining(EmployeeTrainingModel employeeTrainingModel) {
        try {
            if (employeeTrainingModel.getEmployeeId() == null) {
                return new ResponseEntity<Map>(response.clientError("Employee ID is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeTrainingModel.getTrainingId() == null) {
                return new ResponseEntity<Map>(response.clientError("Training ID is required"), HttpStatus.BAD_REQUEST);
            }
            if (employeeTrainingModel.getTrainingDate() == null) {
                return new ResponseEntity<Map>(response.clientError("Training Date is required"), HttpStatus.BAD_REQUEST);
            }
            EmployeeTraining employeeTraining = new EmployeeTraining();
            Employee employee = employeeRepo.findById(employeeTrainingModel.getEmployeeId()).get();
            if (employee == null) {
                return new ResponseEntity<Map>(response.clientError("Employee not found"), HttpStatus.BAD_REQUEST);
            }
            employeeTraining.setEmployee(employee);
            Training training = trainingRepo.findById(employeeTrainingModel.getTrainingId()).get();
            if (training == null) {
                return new ResponseEntity<Map>(response.clientError("Training not found"), HttpStatus.BAD_REQUEST);
            }
            employeeTraining.setTraining(training);
            employeeTraining.setTrainingDate(employeeTrainingModel.getTrainingDate());
            employeeRepo.save(employee);
            return new ResponseEntity<Map>(response.resSuccess(employeeTraining, "Success insert employee training", 201), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.clientError(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
