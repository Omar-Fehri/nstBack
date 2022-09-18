package com.nstgroup.nst.controller;


import com.nstgroup.nst.exception.NotFoundException;
import com.nstgroup.nst.exception.UserFoundException;
import com.nstgroup.nst.model.Role;
import com.nstgroup.nst.model.User;
import com.nstgroup.nst.model.UserRole;
import com.nstgroup.nst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public User createEmployee(@RequestBody User user) throws Exception {
        user.setProfile("default.png");
        //encoding password

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("USER");

        UserRole userRole= new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return userService.createUser(user , roles);

    }

   @GetMapping("/all")
    // @PreAuthorize ("hasRole('MODERATOR') or hasRole('ADMIN')")
        public ResponseEntity<List<User>> getAllUsers () {
        List<User> employees = userService.findAllUsers();
        return new ResponseEntity<>(employees ,  HttpStatus.OK);
    }

    @GetMapping("/{username}")
        public User getUser (@PathVariable("username") String username) {
        return this.userService.getUserByUsername(username);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }


    //update api
    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return ResponseEntity.ok(HttpStatus.OK); }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
}



