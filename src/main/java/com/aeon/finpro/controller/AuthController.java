package com.aeon.finpro.controller;

import com.aeon.finpro.dto.AuthModel;
import com.aeon.finpro.dto.RegisterModel;
import com.aeon.finpro.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/auth/")
@Slf4j
public class AuthController {



    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Map> register(RegisterModel registerModel) {

        try {
            log.info("GlobalController.register() has been called!");
            return authService.register(registerModel);


        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map> authenticate(AuthModel authModel) {

        try {
            log.info("GlobalController.authenticate() has been called!");
            return authService.authenticate(authModel);


        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map> login(AuthModel authModel) {

        try {
            log.info("GlobalController.register() has been called!");
            return authService.login(authModel);
        } catch (Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}