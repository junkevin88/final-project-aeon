package com.aeon.finpro.service.impl;

import com.aeon.finpro.dto.AuthModel;
import com.aeon.finpro.entity.User;
import com.aeon.finpro.config.JwtUtils;
import com.aeon.finpro.dto.RegisterModel;
import com.aeon.finpro.entity.enumeration.Role;
import com.aeon.finpro.repository.UserRepo;
import com.aeon.finpro.service.AuthService;
import com.aeon.finpro.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public Response response;

    public ResponseEntity<Map> register(RegisterModel registerModel) {
        try{
            if(userRepo.existsByUsername(registerModel.getName())){
                return new ResponseEntity<Map>(response.clientError("User is already taken!"), HttpStatus.CREATED);
            }
            User user = new User();
            user.setUsername(registerModel.getName());
            user.setPassword(passwordEncoder.encode(registerModel.getPassword()));
            user.setRole(Role.USER);
            user.setOtp(generateOtp());
            user.setIsEnabled(false);
            userRepo.save(user);
            return new ResponseEntity<Map>(response.resSuccess(user, "Succes register user", 201), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    public String generateOtp() {
        Random random = new Random();
        int otp = random.nextInt(900000) + 100000; // Generate a 6-digit number between 100000 and 999999
        return Integer.toString(otp);
    }


    public ResponseEntity<Map> authenticate(AuthModel authModel) {
        try{
            User user = userRepo.findByUsername(authModel.getName()).orElseThrow();
            if(!user.getOtp().equals(authModel.getOtp())){
                return ResponseEntity.badRequest().body(Map.of("message", "Otp is not valid"));
            } else{
                user.setOtp(null);
                user.setIsEnabled(true);
                userRepo.save(user);
                return new ResponseEntity<Map>(response.resSuccess(user, "Succes authenticate user", 200), HttpStatus.OK);
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

    public ResponseEntity<Map> login(AuthModel authModel) {
        try{
            User user = userRepo.findByUsername(authModel.getName()).orElseThrow();
            if(!user.getIsEnabled()){
                return ResponseEntity.badRequest().body(Map.of("message", "User is not authenticated"));
            } else{
                String token = jwtUtils.generateToken(user);
                user.setTokenValue(token);
                userRepo.save(user);
                return new ResponseEntity<Map>(response.resSuccess(token, "Succes login user", 200), HttpStatus.OK);
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

}