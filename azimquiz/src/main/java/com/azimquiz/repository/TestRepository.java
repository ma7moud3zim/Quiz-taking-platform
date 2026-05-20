package com.azimquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azimquiz.entities.Test;


@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
	
}
