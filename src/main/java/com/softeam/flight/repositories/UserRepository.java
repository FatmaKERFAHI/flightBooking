package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.softeam.flight.entities.User;

public interface UserRepository extends CrudRepository<User, String> {

}
