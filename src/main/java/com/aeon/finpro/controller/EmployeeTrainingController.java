package com.aeon.finpro.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin("*")
@RestController
@RequestMapping("/v1/training-karyawan")
@Slf4j
public class EmployeeTrainingController {

    @PostMapping
    public ResponseEntity<Map> insertEmployeeTraining() {
        return null;
    }


    @GetMapping("/list")
    public ResponseEntity<Map> listEmployeeTraining() {

        return null;
    }


}
