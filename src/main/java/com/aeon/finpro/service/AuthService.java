package com.aeon.finpro.service;

import com.aeon.finpro.dto.AuthModel;
import com.aeon.finpro.dto.RegisterModel;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface AuthService {
    public ResponseEntity<Map> register(RegisterModel registerModel);
    public String generateOtp();
    public ResponseEntity<Map> authenticate(AuthModel authModel);
    public ResponseEntity<Map> login(AuthModel authModel);
}
