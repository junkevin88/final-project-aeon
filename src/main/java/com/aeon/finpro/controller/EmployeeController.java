package com.aeon.finpro.controller;

import com.aeon.finpro.dto.EmployeeModel;
import com.aeon.finpro.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/karyawan")
@Slf4j
public class EmployeeController {

        @Autowired
        EmployeeService employeeService;


        @PostMapping
        public ResponseEntity<Map> insertEmployee(EmployeeModel employeeModel) {

                try{
                        log.info("EmployeeController.insertEmployee() has been called!");
                        return new ResponseEntity(employeeService.insertEmployee(employeeModel), HttpStatus.OK);

                }catch (Exception e) {
                        log.error("ERROR has been found! because : {}", e.getMessage());
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
        }

        @PutMapping
        public ResponseEntity<Map> updateEmployee() {

                return null;
        }

        @GetMapping("/list")
        public ResponseEntity<Map> listEmployee() {

                return null;
        }

        @GetMapping("/{id}")
        public ResponseEntity<Map> getByIdEmployee() {
                return null;
        }



}
