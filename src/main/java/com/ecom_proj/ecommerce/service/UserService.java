package com.ecom_proj.ecommerce.service;


import com.ecom_proj.ecommerce.dto.UserDTO;
import com.ecom_proj.ecommerce.dto.UserResponseDTO;
import com.ecom_proj.ecommerce.model.User;
import com.ecom_proj.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    private UserResponseDTO mapUserEntityToResponseDto(User user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());

        return dto;
    }



    public List<UserResponseDTO> getAllUser() {
        return userRepo.findAll().stream()
                .map(this::mapUserEntityToResponseDto)
                .toList();
    }

    public UserResponseDTO getUserById(Long id) {
        User user = userRepo.findById(id).orElse(null);
        if(user != null){
            return mapUserEntityToResponseDto(user);
        }
        return null;
    }

    public UserResponseDTO updateUser(Long id, UserDTO userDto){
        User existingUser = userRepo.findById(id).orElse(null);

        if(existingUser != null){
            mapDtoToUser(userDto, existingUser);
            User u = userRepo.save(existingUser);
            return mapUserEntityToResponseDto(u);
        }
        return null;
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }


    public UserResponseDTO addUser(UserDTO userDto) {
        User user = mapDtoToUser(userDto, new User());
        User savedUser = userRepo.save(user);
        return mapUserEntityToResponseDto(savedUser);
    }

    private User mapDtoToUser (UserDTO userDto, User user) {
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        return user;
    }

}
