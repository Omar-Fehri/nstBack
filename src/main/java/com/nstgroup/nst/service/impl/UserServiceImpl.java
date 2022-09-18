package com.nstgroup.nst.service.impl;

import com.nstgroup.nst.exception.NotFoundException;
import com.nstgroup.nst.exception.UserFoundException;
import com.nstgroup.nst.model.User;
import com.nstgroup.nst.model.UserRole;
import com.nstgroup.nst.repository.RoleRepository;
import com.nstgroup.nst.repository.UserRepository;
import com.nstgroup.nst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    // create employee
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
       User local =  this.userRepository.findByUsername(user.getUsername());

       if (local!= null ) {
           System.out.println("Employee is already there !! ");
           throw new UserFoundException();
        } else {
           //create employee
           for (UserRole ur:userRoles) {
               roleRepository.save(ur.getRole());
           }

           user.getUserRoles().addAll(userRoles);
           local = this.userRepository.save(user);

       }

        return local ;
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id)
                .orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
    }

}
