package com.ecom_proj.ecommerce.controller;


import com.ecom_proj.ecommerce.dto.UserDTO;
import com.ecom_proj.ecommerce.dto.UserResponseDTO;
import com.ecom_proj.ecommerce.model.User;
import com.ecom_proj.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponseDTO> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id,
                           @Valid @RequestBody UserDTO userDto){
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PostMapping("/register")
    public UserResponseDTO addUser(@Valid @RequestBody UserDTO userDto){
        return userService.addUser(userDto);
    }




}
