package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.softeam.flight.entities.User;

// TODO: Auto-generated Javadoc
/**
 * @author Mosbah Mohamed Ali
 * The Interface UserRepository.
 */
public interface UserRepository extends JpaRepository<User,Long>{
	
	/**
	 * Find by username.
	 *
	 * @param username the username
	 * @return the user
	 */
	//List<User> findByNameAndFirstName(String name, String firstName);
	public User findByUsername(String username);

	/**
	 * Find byusername.
	 *
	 * @param username the username
	 * @return the user
	 */
	public User findByusername(String username);
	@Modifying
    @Query(value = "insert into user_roles values (:user_id_passenger,:roles_id)", nativeQuery = true)
    @Transactional
    public void setRole(@Param("user_id_passenger") Long id, @Param("roles_id") long titre);
}
