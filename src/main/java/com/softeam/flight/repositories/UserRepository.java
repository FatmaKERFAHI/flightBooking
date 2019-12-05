package com.softeam.flight.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeam.flight.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
