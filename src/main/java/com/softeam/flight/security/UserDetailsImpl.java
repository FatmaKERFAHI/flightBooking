package com.softeam.flight.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.softeam.flight.entities.Role;
import com.softeam.flight.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDetailsImpl.
 *  @author Mosbah Mohamed Ali
 */
public class UserDetailsImpl implements UserDetails {

	/** The user. */
	private User user;


	/**
	 * Instantiates a new user details impl.
	 *
	 * @param user the user
	 */
	public UserDetailsImpl(User user) {
		this.user = user;
	}

	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (final Role role : user.getRoles())
			authorities.add(new SimpleGrantedAuthority(role.getTitre()));
		return authorities;
	}
	
	/**
	 * Checks if is account non expired.
	 *
	 * @return true, if is account non expired
	 */
	@Override
	public boolean isAccountNonExpired() {
	  return true;
	}
	
	/**
	 * Checks if is account non locked.
	 *
	 * @return true, if is account non locked
	 */
	@Override
	public boolean isAccountNonLocked() {
	  return true;
	}
	
	/**
	 * Checks if is credentials non expired.
	 *
	 * @return true, if is credentials non expired
	 */
	@Override
	public boolean isCredentialsNonExpired() {
	  return true;
	}
	
	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	@Override
	public boolean isEnabled() {
	  return true;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	@Override
	public String getUsername() {
	  return user.getUsername();
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@Override
	public String getPassword() {
	  return user.getPassword();
	}
	


}