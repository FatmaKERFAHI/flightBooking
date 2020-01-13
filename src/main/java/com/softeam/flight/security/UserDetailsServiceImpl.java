package com.softeam.flight.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softeam.flight.entities.User;
import com.softeam.flight.repositories.UserRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetailsServiceImpl.
 *  @author Mosbah Mohamed Ali
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	/** The user repository. */
	@Autowired 
	UserRepository userRepository;
	
	  /**
  	 * Load user by username.
  	 *
  	 * @param username the username
  	 * @return the user details impl
  	 * @throws UsernameNotFoundException the username not found exception
  	 */
  	@Override
	  public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
		  
	    User user=userRepository.findByUsername(username);
	    if(null == user){
	      throw new UsernameNotFoundException("No user named "+username);
	    }
	    else{
	      return new UserDetailsImpl(user);
	    }
	  }

}
