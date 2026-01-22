package org.hashlearning.backend.controller;

import org.hashlearning.backend.model.Roles;
import org.hashlearning.backend.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configurers.HttpsRedirectConfigurer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping("/roles")
    public ResponseEntity<List<Roles>> getAllCourses(){
        return new ResponseEntity<>(rolesService.getAllCourses(), HttpStatus.OK);
    }

    @PostMapping("/role")
    public String addRole(@RequestBody Roles role){
        return rolesService.addRole(role);
    }


}
