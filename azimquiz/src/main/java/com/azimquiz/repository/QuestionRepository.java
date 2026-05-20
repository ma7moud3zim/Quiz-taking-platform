package com.azimquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azimquiz.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
	
}
