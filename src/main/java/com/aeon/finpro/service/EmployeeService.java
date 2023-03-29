package com.aeon.finpro.service;

import com.aeon.finpro.dto.EmployeeModel;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface EmployeeService {
    public ResponseEntity<Map> insertEmployee(EmployeeModel employeeModel);
}
