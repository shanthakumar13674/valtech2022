package com.valtech.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.spring.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);

}
