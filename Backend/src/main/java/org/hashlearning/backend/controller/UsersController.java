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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
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
    public ResponseEntity<List<Users>> getAllUsers(){
        return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public  ResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest loginRequest){
        if (service.userLogin(loginRequest)!= null){
            return  new ResponseEntity<>(service.userLogin(loginRequest), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
