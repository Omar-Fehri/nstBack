package com.nstgroup.nst;


import com.nstgroup.nst.exception.UserFoundException;
import com.nstgroup.nst.model.Role;
import com.nstgroup.nst.model.User;
import com.nstgroup.nst.model.UserRole;

import com.nstgroup.nst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class NstApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(NstApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*try {
			System.out.println("starting code");

			User user = new User();

			user.setFirstname("Omar");
			user.setLastname("Fehri");
			user.setUsername("admin");
			user.setPassword(this.bCryptPasswordEncoder.encode("admin123"));
			user.setEmail("admin@gmail.com");
			user.setProfile("default.png");

			Role role1 = new Role();
			role1.setRoleId(44L);
			role1.setRoleName("Admin");

			Set<UserRole> userRoleSet = new HashSet<>();
			UserRole userRole = new UserRole();
			userRole.setRole(role1);
			userRole.setUser(user);

			userRoleSet.add(userRole);

			User user1 = this.userService.createUser(user, userRoleSet);
			System.out.println(user1.getUsername());

		}catch(UserFoundException e)
		{
			e.printStackTrace();
		}*/
	}


}
