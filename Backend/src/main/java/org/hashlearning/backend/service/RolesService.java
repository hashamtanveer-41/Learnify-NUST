package org.hashlearning.backend.service;

import org.hashlearning.backend.model.Roles;
import org.hashlearning.backend.repo.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    @Autowired
    private RolesRepo rolesRepo;


    public List<Roles> getAllCourses() {
       return rolesRepo.findAll();
    }


    public String addRole(Roles role) {
        rolesRepo.save(role);
        if (role.getId()!= 0){
            return "Role added Successfully";
        }else {
            return "Role was not added";
        }
    }
}
