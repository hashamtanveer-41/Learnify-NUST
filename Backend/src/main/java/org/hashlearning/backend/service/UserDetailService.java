package org.hashlearning.backend.service;

import org.hashlearning.backend.model.Users;
import org.hashlearning.backend.model.UsersPrinciple;
import org.hashlearning.backend.model.dto.UsersRequest;
import org.hashlearning.backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user =  userRepo.findUsersByEmail(email);
        if (user==null){
            System.out.println("EROR: 404");
            throw new UsernameNotFoundException("ERROR: 404");
        }
        return new UsersPrinciple(user);
    }
}
