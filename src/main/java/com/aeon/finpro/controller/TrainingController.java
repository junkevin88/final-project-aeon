package com.aeon.finpro.controller;


import com.aeon.finpro.dto.TrainingModel;
import com.aeon.finpro.entity.Employee;
import com.aeon.finpro.repository.EmployeeRepo;
import com.aeon.finpro.repository.TrainingRepo;
import com.aeon.finpro.service.EmployeeService;
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
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/training")
@Slf4j
public class TrainingController {

    @Autowired
    private TrainingRepo trainingRepo;

    @Autowired
    TrainingService trainingService;


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map> insertTraining(TrainingModel trainingModel) {

        try {
            log.info("TrainingController.insertTraining() has been called!");
            return new ResponseEntity(trainingService.insertTraining(trainingModel), HttpStatus.CREATED);

        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map> updateTraining(TrainingModel trainingModel) {

        try {
            log.info("TrainingController.updateTraining() has been called!");
            return new ResponseEntity(trainingService.updateTraining(trainingModel), HttpStatus.OK);

        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Map> listTraining(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "ASC") String sort,
            @RequestParam(value = "search", defaultValue = "") String search
    ) {
        try {
            log.info("TrainingController.listTraining() has been called!");
            Pageable show_data = PageRequest.of(page, size, Sort.Direction.fromString(sort), "topic");
            Page<Employee> list = null;
            list = trainingRepo.findListTraining(search, show_data);
            return new ResponseEntity(list, HttpStatus.OK);

        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Map> getByIdTraining(@PathVariable("id") UUID id) {
        try {
            log.info("TrainingController.getByIdTraining() has been called!");
            return new ResponseEntity(trainingService.getTrainingById(id), HttpStatus.OK);

        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }    }

}
