package com.ecom_proj.ecommerce.controller;


import com.ecom_proj.ecommerce.dto.LoginRequestDTO;
import com.ecom_proj.ecommerce.dto.LoginResponseDTO;
import com.ecom_proj.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDto) {
        return authService.login(loginRequestDto);
    }
}
