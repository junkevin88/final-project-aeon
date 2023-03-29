package com.aeon.finpro.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/training")
@Slf4j
public class TrainingController {

    @PostMapping
    public ResponseEntity<Map> insertTraining() {

        return null;
    }

    @PutMapping
    public ResponseEntity<Map> updateTraining() {

        return null;
    }

    @GetMapping("/list")
    public ResponseEntity<Map> listTraining() {

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> getByIdTraining() {
        return null;
    }

}
