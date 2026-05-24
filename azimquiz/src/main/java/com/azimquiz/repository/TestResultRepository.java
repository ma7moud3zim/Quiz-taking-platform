package com.azimquiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azimquiz.entities.TestResult;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {

}
