package com.azimquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azimquiz.entities.User;
import com.azimquiz.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByRole(UserRole admin);
	Boolean findFirstByEmail(String email);
	
}
