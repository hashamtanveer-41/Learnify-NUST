package org.hashlearning.backend.controller;


import org.hashlearning.backend.model.Users;
import org.hashlearning.backend.model.dto.LoginRequest;
import org.hashlearning.backend.model.dto.LoginResponse;
import org.hashlearning.backend.model.dto.UserResponse;
import org.hashlearning.backend.model.dto.UsersRequest;
import org.hashlearning.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableMethodSecurity
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UsersRequest usersRequest){
        UserResponse userResponse = service.registerUser(usersRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public  ResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest loginRequest){
        LoginResponse response = service.userLogin(loginRequest);
        if (response!= null){
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }


    @PutMapping("/register")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UsersRequest usersRequest){
        return new ResponseEntity<>(service.registerUser(usersRequest), HttpStatus.OK);
    }


    @DeleteMapping("/users/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteUser(@PathVariable int userId){
        return service.deleteUserById(userId);
    }
}
