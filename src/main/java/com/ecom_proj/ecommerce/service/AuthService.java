package com.ecom_proj.ecommerce.service;

import com.ecom_proj.ecommerce.dto.LoginRequestDTO;
import com.ecom_proj.ecommerce.dto.LoginResponseDTO;
import com.ecom_proj.ecommerce.model.User;
import com.ecom_proj.ecommerce.repository.UserRepo;
import com.ecom_proj.ecommerce.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public ResponseEntity<LoginResponseDTO> login(LoginRequestDTO loginRequestDto){
        User user = userRepo.findByUsername(loginRequestDto.getUsername());

        if(user == null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new LoginResponseDTO("User not found", null));
        }
        if(passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())){
            String token = jwtService.generateToken(user.getUsername() ,user.getRole().name());
            return ResponseEntity
                    .ok(new LoginResponseDTO("Login successful", token));
        }
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new LoginResponseDTO("Invalid password", null));
    }
}
