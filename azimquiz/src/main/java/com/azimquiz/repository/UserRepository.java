package com.azimquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azimquiz.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
