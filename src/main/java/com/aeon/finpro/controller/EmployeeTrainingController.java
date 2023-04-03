package com.aeon.finpro.controller;

import com.aeon.finpro.dto.EmployeeTrainingModel;
import com.aeon.finpro.entity.Employee;
import com.aeon.finpro.entity.EmployeeTraining;
import com.aeon.finpro.repository.EmployeeTrainingRepo;
import com.aeon.finpro.repository.TrainingRepo;
import com.aeon.finpro.service.EmployeeTrainingService;
import com.aeon.finpro.service.TrainingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin("*")
@RestController
@RequestMapping("/v1/training-karyawan")
@Slf4j
public class EmployeeTrainingController {

    @Autowired
    private EmployeeTrainingRepo employeeTrainingRepo;

    @Autowired
    EmployeeTrainingService employeeTrainingService;

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Map> insertEmployeeTraining(EmployeeTrainingModel employeeTrainingModel) {
        try {
            log.info("EmployeeTrainingController.insertEmployeeTraining() has been called!");
            return new ResponseEntity(employeeTrainingService.insertEmployeeTraining(employeeTrainingModel), HttpStatus.CREATED);

        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Map> listEmployeeTraining(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "ASC") String sort,
            @RequestParam(value = "sortBy") String sortBy,
            @RequestParam(value = "searchName", defaultValue = "") String searchName,
            @RequestParam(value = "searchTopic", defaultValue = "") String searchTopic

    ) {
        try {
            log.info("EmployeeTrainingController.listEmployeeTraining() has been called!");
            Pageable show_data = PageRequest.of(page, size, Sort.Direction.fromString(sort), sortBy);
            Page<EmployeeTraining> list = null;
            list = employeeTrainingRepo.findListEmployeeTraining(searchName, searchTopic, show_data);
            return new ResponseEntity(list, HttpStatus.OK);

        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
