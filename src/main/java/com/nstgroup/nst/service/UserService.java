package com.nstgroup.nst.service;


import com.nstgroup.nst.model.User;
import com.nstgroup.nst.model.UserRole;


import java.util.List;
import java.util.Set;




public interface UserService {

    public User createUser(User user , Set<UserRole> userRoles) throws Exception;

    public User getUserByUsername(String username);

    public void deleteUser(Long id);

    List<User> findAllUsers();

    User updateUser(User user);

    public User findUserById(Long id);


}
