package com.softeam.flight.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softeam.flight.entities.Role;
import com.softeam.flight.entities.User;
import com.softeam.flight.repositories.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRestController.
 * @author Mosbah Mohamed Ali
 */
@CrossOrigin
@RestController
public class UserRestController {
	
	/** The User repository. */
	@Autowired
	private UserRepository UserRepository;


	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @return the int
	 */
	@PostMapping("/adduser")
    public int addUser(@RequestBody User user) {
        System.out.println(user.getRoles().toString());
        User u = UserRepository.findByUsername(user.getUsername());
        UserRepository.setRole(u.getIdPassenger(), (long) 2);
        UserRepository.save(user);
        return 200;
    }

	/**
	 * Vis user.
	 *
	 * @return the list
	 */
	// @PostAuthorize("hasRole('admin')")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/getusers")
	public List<User> visUser() {

		return UserRepository.findAll();

	}

	/**
	 * Vis user 2.
	 *
	 * @return the list
	 */
	@Secured("user")
	@GetMapping("/getuserss")
	public List<User> visUser2() {

		return UserRepository.findAll();


	}

	/**
	 * Vis user role.
	 *
	 * @param username the username
	 * @return the list
	 */
	@Secured("user")
	@GetMapping("/getusersrole")
	public List<Role> visUserRole(String username) {

		User user;
		user = UserRepository.findByusername(username);
		return user.getRoles();

	}
}
