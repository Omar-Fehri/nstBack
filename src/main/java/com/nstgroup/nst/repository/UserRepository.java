package com.nstgroup.nst.repository;


import com.nstgroup.nst.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {


    public User findByUsername(String username);

    Optional<User> findUserById(Long id);
}
