package com.aeon.finpro.controller;

import com.aeon.finpro.dto.EmployeeModel;
import com.aeon.finpro.entity.Employee;
import com.aeon.finpro.repository.EmployeeRepo;
import com.aeon.finpro.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/karyawan")
@Slf4j
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<Map> insertEmployee(EmployeeModel employeeModel) {

        try {
            log.info("EmployeeController.insertEmployee() has been called!");
            return new ResponseEntity(employeeService.insertEmployee(employeeModel), HttpStatus.CREATED);

        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Map> updateEmployee(EmployeeModel employeeModel) {
        try {
            log.info("EmployeeController.updateEmployee() has been called!");
            return new ResponseEntity(employeeService.updateEmployee(employeeModel), HttpStatus.OK);

        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/list")
    public ResponseEntity<Map> listEmployee(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "ASC") String sort,
            @RequestParam(value = "search", defaultValue = "") String search
    ) {
        try {
            log.info("EmployeeController.listEmployee() has been called!");
            Pageable show_data = PageRequest.of(page, size, Sort.Direction.fromString(sort), "name");
            Page<Employee> list = null;
            list = employeeRepo.findListEmployee(search, show_data);
            return new ResponseEntity(list, HttpStatus.OK);

        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> getByIdEmployee(@PathVariable("id") UUID id) {
        try {
            log.info("EmployeeController.getByIdEmployee() has been called!");
            return new ResponseEntity(employeeService.getEmployeeById(id), HttpStatus.OK);

        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}



