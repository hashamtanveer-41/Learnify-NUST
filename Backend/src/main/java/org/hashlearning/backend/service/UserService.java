package org.hashlearning.backend.service;

import org.hashlearning.backend.model.Roles;
import org.hashlearning.backend.model.Users;
import org.hashlearning.backend.model.dto.UserResponse;
import org.hashlearning.backend.model.dto.UsersRequest;
import org.hashlearning.backend.repo.RolesRepo;
import org.hashlearning.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RolesRepo rolesRepo;


    private final BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(14);

    public UserResponse registerUser(UsersRequest usersRequest) {
        Users user = new Users();
        Roles role = new Roles();
        role.setName("admin");

        user.setEmail(usersRequest.email());
        user.setName(usersRequest.name());
        user.setRole_id(rolesRepo
                .findById(usersRequest
                        .role_id())
                .orElseThrow(()-> new RuntimeException("Role not found")));
        user.setPassword(encoder.encode(usersRequest.password()));
        userRepo.save(user);

        return new UserResponse(
                "User registered Successfully",
                user.getId()
        );
    }

    public List<Users> findAllUsers() {
        return userRepo.findAll();
    }
}
