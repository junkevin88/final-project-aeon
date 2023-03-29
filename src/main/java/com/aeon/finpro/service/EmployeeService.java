package com.aeon.finpro.service;

import com.aeon.finpro.dto.EmployeeModel;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface EmployeeService {
    public ResponseEntity<Map> insertEmployee(EmployeeModel employeeModel);
    public ResponseEntity<Map> updateEmployee(EmployeeModel employeeModel);
    public ResponseEntity<Map> getEmployeeById(UUID id);
}
